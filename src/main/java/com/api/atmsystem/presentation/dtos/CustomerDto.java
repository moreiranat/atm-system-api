package com.api.atmsystem.presentation.dtos;

import com.api.atmsystem.model.entities.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Long id;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    private String address;

//    @JsonFormat(pattern = "dd/MM/yy")
//    @DateTimeFormat(pattern = "dd/MM/yy")
//    @NotBlank
//    private LocalDate dateOfBirth;

    @NotBlank
    @Size(max = 30)
    private String cardNumber;

    @NotBlank
    @Size(max = 30)
    private String pin;

//    public CustomerDto(Customer customer) {
//        this.id = customer.getId();
//        this.name = customer.getName();
//        this.address = customer.getAddress();
//        this.dateOfBirth = customer.getDateOfBirth();
//        this.getCardNumber() = customer.getCardNumber();
//        this.getPin() = customer.getPin();
//    }
//
//    public static List<CustomerDto> converter(List<Customer> customers) {
//        return customers.stream().map(CustomerDto::new).collect(Collectors.toList());
//    }
}