package net.javaguides.banking_app.mapper;

import lombok.AllArgsConstructor;
import net.javaguides.banking_app.dto.AccountDetailDto;
import net.javaguides.banking_app.entity.AccountDetail;

@AllArgsConstructor
public class AccountDetailMapper {

    public static AccountDetailDto mapToAccountDetailDto(AccountDetail accountDetail){
        return new AccountDetailDto(
                accountDetail.getId(),
                accountDetail.getAccountNo(),
                accountDetail.getName(),
                accountDetail.getAccountBalance()
        );
    }

    public static AccountDetail mapToAccountDetail(AccountDetailDto accountDetailDto){
        return new AccountDetail(
                accountDetailDto.id(),
                accountDetailDto.accountNo(),
                accountDetailDto.name(),
                accountDetailDto.accountBalance()
        );
    }
}
