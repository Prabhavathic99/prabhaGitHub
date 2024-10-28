package net.javaguides.banking_app.dto;

import jakarta.persistence.Column;
import lombok.*;

/*@Data
@AllArgsConstructor
public class AccountDetailDto {

    private Long id;
    private String accountNo;
    private String name;
    private double accountBalance;

}*/

public record AccountDetailDto(Long id, String accountNo, String name, double accountBalance) { }
