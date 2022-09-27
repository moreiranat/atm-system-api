package com.api.atmsystem.presentation.controllers;

import com.api.atmsystem.business.services.CustomerService;
import com.api.atmsystem.model.entities.Customer;
import com.api.atmsystem.presentation.dtos.CustomerDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCustomer(@RequestBody @Valid CustomerDto customerDto){
        if(customerService.existsByName(customerDto.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Name is already in use!");
        }
        if(customerService.existsByCardNumber(customerDto.getCardNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Card Number is already in use!");
        }
        var customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer); //conversao de dto para model passando o que vai ser convertido, no que vai ser convertido
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
    }


}
