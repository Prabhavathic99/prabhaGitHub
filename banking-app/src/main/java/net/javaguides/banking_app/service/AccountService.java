package net.javaguides.banking_app.service;

import net.javaguides.banking_app.dto.AccountDetailDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountService {

    AccountDetailDto createCustomerAccount(AccountDetailDto accountDetailDto);

    AccountDetailDto getAccountDetailById(Long id);

    AccountDetailDto addBalance(Long id, double amount);

    AccountDetailDto takeAmount(Long id, double amount);

    List<AccountDetailDto> getAllAccount();

    void deleteAccount(Long id);
}
