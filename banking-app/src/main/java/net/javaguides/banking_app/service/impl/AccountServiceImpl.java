package net.javaguides.banking_app.service.impl;

import net.javaguides.banking_app.dto.AccountDetailDto;
import net.javaguides.banking_app.entity.AccountDetail;
import net.javaguides.banking_app.mapper.AccountDetailMapper;
import net.javaguides.banking_app.repository.AccountRepository;
import net.javaguides.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {


    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDetailDto createCustomerAccount(AccountDetailDto accountDetailDto) {
        AccountDetail detail = AccountDetailMapper.mapToAccountDetail(accountDetailDto);
        AccountDetail savedDetail = accountRepository.save(detail);
        return AccountDetailMapper.mapToAccountDetailDto(savedDetail);
    }

    @Override
    public AccountDetailDto getAccountDetailById(Long id) {
        AccountDetail accountDetail = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Not Found"));
        return AccountDetailMapper.mapToAccountDetailDto(accountDetail);
    }

    @Override
    public AccountDetailDto addBalance(Long id, double amount) {
        AccountDetail accountDetail = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Not Found"));
        double total = accountDetail.getAccountBalance() + amount;
        accountDetail.setAccountBalance(total);
        AccountDetail updatedAccount = accountRepository.save(accountDetail);
        return AccountDetailMapper.mapToAccountDetailDto(updatedAccount);
    }

    @Override
    public AccountDetailDto takeAmount(Long id, double amount) {
        AccountDetail accountDetail = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Not Found"));
        if(accountDetail.getAccountBalance()<amount){
            throw new RuntimeException("Insufficient Balance");
        }
        double total = accountDetail.getAccountBalance() - amount;
        accountDetail.setAccountBalance(total);
        AccountDetail updatedAccount = accountRepository.save(accountDetail);
        return AccountDetailMapper.mapToAccountDetailDto(updatedAccount);
    }

    @Override
    public List<AccountDetailDto> getAllAccount() {
        List<AccountDetail> accountDetails = accountRepository.findAll();
        return accountDetails.stream().map(acc->AccountDetailMapper.mapToAccountDetailDto(acc)).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        AccountDetail accountDetail = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Not Found"));
        accountRepository.deleteById(id);
    }
}
