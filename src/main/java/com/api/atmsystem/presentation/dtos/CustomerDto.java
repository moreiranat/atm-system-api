package com.api.atmsystem.presentation.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    @NotBlank
    @Size(max = 30)
    private String cardNumber;

    @NotBlank
    @Size(max = 30)
    private String pin;

    @NotBlank
    @CPF(message = "informe um CPF válido")
    private String cpf;

}