package com.api.atmsystem.model.repositories;

import com.api.atmsystem.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByCpf(String cpf);

    boolean existsByCardNumber(String cardNumber);

}
