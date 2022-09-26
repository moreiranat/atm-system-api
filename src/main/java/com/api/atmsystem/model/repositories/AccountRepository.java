package com.api.atmsystem.model.repositories;

import com.api.atmsystem.model.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
