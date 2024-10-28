package net.javaguides.banking_app.repository;

import net.javaguides.banking_app.entity.AccountDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountDetail, Long> { }
