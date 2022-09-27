package com.api.atmsystem.business.services;

import com.api.atmsystem.model.entities.Customer;
import com.api.atmsystem.model.repositories.CustomerRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    @Transactional
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

    @Transactional
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    public Page<Customer> findAll(Pageable pageable) {

        return customerRepository.findAll(pageable);
    }

    public Optional<Customer> findById(long id) {

        return customerRepository.findById(id);
    }

    public Iterable<Customer> findByFilter(Customer filter) {

        Example example = Example.of(filter,
                ExampleMatcher.matching()
                        .withIgnoreCase()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));

        return customerRepository.findAll(example);
    }

    public boolean existsByName(String name) {

        return customerRepository.existsByName(name);
    }

    public boolean existsByCardNumber(String cardNumber) {

        return customerRepository.existsByCardNumber(cardNumber);
    }
}

//******************************************************************
//    @Transactional
//    public void delete(Long id) {
//        Customer customer = findById(id);
//
//        if (customer == null) {
//            throw new IllegalStateException(String.format("Could not find a entity with id=%1", id));
//        }
//        customerRepository.deleteById((id));
//    }
//
//    public Customer findById(Long id) {
//        if(id == null) {
//            throw new IllegalStateException("Id cannot be null");
//        }
//        return customerRepository.findById(id).get();
//    }
