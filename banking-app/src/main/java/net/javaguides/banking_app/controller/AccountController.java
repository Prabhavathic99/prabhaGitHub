package net.javaguides.banking_app.controller;

import net.javaguides.banking_app.dto.AccountDetailDto;
import net.javaguides.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/bank")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // create new account
    @PostMapping("/new/account")
    public ResponseEntity<AccountDetailDto> createNewAccountDetail(@RequestBody AccountDetailDto accountDetailDto){
        return new ResponseEntity<>(accountService.createCustomerAccount(accountDetailDto), HttpStatus.CREATED);
    }

    // get account detail
    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDetailDto> getAccount(@PathVariable Long id){
        return new ResponseEntity<>(accountService.getAccountDetailById(id), HttpStatus.OK);
    }

    // deposit amount
    @PutMapping("{id}/deposit")
    public ResponseEntity<AccountDetailDto> depositAmount(@PathVariable Long id, @RequestBody Map<String, Double> request){
        double amount = request.get("accountBalance");
        AccountDetailDto accountDetailDto = accountService.addBalance(id,amount);
        return new ResponseEntity<>(accountDetailDto,HttpStatus.OK);
    }

    // withdraw amount
    @PutMapping("{accId}/withdraw")
    public ResponseEntity<AccountDetailDto> withdrawAmount(@PathVariable("accId") Long id, @RequestBody Map<String, Double> request){
        double amount = request.get("accountBalance");
        AccountDetailDto accountDetailDto = accountService.takeAmount(id,amount);
        return ResponseEntity.ok(accountDetailDto);
    }

    // get all account details
    @GetMapping("all/account")
    public ResponseEntity<List<AccountDetailDto>> getAllAccountDetails(){
        List<AccountDetailDto> accountDetailDtoList = accountService.getAllAccount();
        return new ResponseEntity<>(accountDetailDtoList,HttpStatus.OK);
    }

    // delete account
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted");
    }

}
