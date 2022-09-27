package com.api.atmsystem.business.services.impl;

import com.api.atmsystem.model.entities.Customer;
import com.api.atmsystem.presentation.dtos.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerConverterServiceImpl  {

    public List<CustomerDto> customerToDTO(List<Customer> entities) {
        List<CustomerDto> dtos = new ArrayList<>();

        for (Customer dto : entities) {
            CustomerDto entity = customerToDTO(dto);
            dtos.add(entity);
        }
        return dtos;
    }

    public Customer dtoToCustomer(CustomerDto dto) {

        Customer entity = new Customer();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setCardNumber(dto.getCardNumber());
        entity.setPin(dto.getPin());

        return entity;
    }

    public CustomerDto customerToDTO(Customer entity) {

       CustomerDto dto = new CustomerDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setCardNumber(entity.getCardNumber());

        return dto;
    }
}
