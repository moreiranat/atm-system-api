package com.api.atmsystem.business.services;

import com.api.atmsystem.model.entities.Customer;
import com.api.atmsystem.model.repositories.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        if (customer.getId() != null) {
            throw new IllegalStateException("Customer is already in the database");
        }
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer) {
        if(!customerRepository.existsById(customer.getId())) {
            throw new IllegalStateException("Customer id is null");
        }
        return customerRepository.save(customer);
    }

    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    public Page<Customer> findAll(Pageable pageable) {

        return customerRepository.findAll(pageable);
    }

    public Optional<Customer> findById(long id) {

        return customerRepository.findById(id);
    }

    public boolean existsByCpf(String cpf) {

        return customerRepository.existsByCpf(cpf);
    }

    public boolean existsByCardNumber(String cardNumber) {

        return customerRepository.existsByCardNumber(cardNumber);
    }


}
