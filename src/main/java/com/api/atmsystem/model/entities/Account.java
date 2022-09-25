package com.api.atmsystem.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_ACCOUNT")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private Long number;

    @Column(name = "balance", nullable = false)//não coloca o setBalance, pois o saldo não pode ser modificado (encapsulamento)
    protected BigDecimal balance;

    @ManyToOne //muitas contas para 1 cliente
    @JoinColumn(name = "customer_id")
    private Customer customer;

//    @JsonIgnore
//    @OneToMany(mappedBy = "account")
//    private Set<AtmTransactions> transactions;
//
//    @ManyToOne
//    @JoinColumn(name = "bank_id")
//    private Bank bank;

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    public void createTransaction(BigDecimal amount) {
        //implementacao do metodo createTransaction
    }
}

