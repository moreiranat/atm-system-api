package com.api.atmsystem.presentation.controllers;

import com.api.atmsystem.business.services.CustomerService;
import com.api.atmsystem.model.entities.Customer;
import com.api.atmsystem.presentation.dtos.CustomerDto;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCustomer(@RequestBody @Valid CustomerDto customerDto){
        if(customerService.existsByName(customerDto.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Name is already in use!");
        }
        if(customerService.existsByCardNumber(customerDto.getCardNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Card Number is already in use!");
        }
        var customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer); //conversao de dto para model passando o que vai ser convertido, no que vai ser convertido
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
    }

    @GetMapping //findAll
    public ResponseEntity<Page<Customer>> findAllCustomers(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll(pageable));
    }

    @GetMapping("/{id}") //findById
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id){
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(customerOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable(value = "id") Long id){
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
        }
        customerService.delete(customerOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Customer deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable(value = "id") Long id,
                                                 @RequestBody @Valid CustomerDto customerDto){
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
        }
        var customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customer.setId(customerOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(customerService.update(customer));
    }

}


//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateCustomer(@PathVariable(value = "id") Long id,
//                                                 @RequestBody @Valid CustomerDto customerDto){
//        Optional<Customer> customerOptional = customerService.findById(id);
//        if (!customerOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
//        }
//        var customer = customerOptional.get();
//        var idDoCustomer = customerOptional.get().getId();
//        BeanUtils.copyProperties(customerDto, customer);
//        customer.setId(idDoCustomer);
//        return ResponseEntity.status(HttpStatus.OK).body(customerService.update(customer));
//    }
