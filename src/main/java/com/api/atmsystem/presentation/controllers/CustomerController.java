package com.api.atmsystem.presentation.controllers;

import com.api.atmsystem.business.services.CustomerService;
import com.api.atmsystem.model.entities.Customer;
import com.api.atmsystem.model.repositories.CustomerRepository;
import com.api.atmsystem.presentation.dtos.CustomerDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;


    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;
    }

    @PostMapping
    @ApiOperation("Salva um novo customer")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Customer saved successfully"),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 409, message = "Conflict")
    })
    public ResponseEntity saveCustomer(@RequestBody @Valid CustomerDto customerDto){
        if(customerService.existsByCpf(customerDto.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("There is already a customer with that CPF!");
        }
        if(customerService.existsByCardNumber(customerDto.getCardNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Card Number is already in use!");
        }
        var customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer); //conversao de dto para model passando o que vai ser convertido, no que vai ser convertido
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
    }

    @GetMapping //findAll
    @ApiOperation("Obter todos os customers salvos no banco de dados")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Customers found")
    })
    public ResponseEntity<Page<Customer>> findAllCustomers(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll(pageable));
    }

    @GetMapping("/{id}") //findById
    @ApiOperation("Obter detalhes de um customer")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Customer found"),
            @ApiResponse(code = 404, message = "Customer not found for the given ID")
    })
    public ResponseEntity findById(@PathVariable(value = "id") Long id){
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(customerOptional.get());
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deleta um customer")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Customer found"),
            @ApiResponse(code = 404, message = "Customer not found for the given ID")
    })
    public ResponseEntity deleteCustomer(@PathVariable(value = "id") Long id){
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
        }
        customerService.delete(customerOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Customer deleted successfully.");
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza um customer")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Customer found"),
            @ApiResponse(code = 404, message = "Customer not found for the given ID")
    })
    public ResponseEntity updateCustomer(@PathVariable(value = "id") Long id,
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
