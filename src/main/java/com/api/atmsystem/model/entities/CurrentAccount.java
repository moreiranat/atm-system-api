package com.api.atmsystem.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurrentAccount extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    //@OneToOne(mappedBy = "currentAccount", cascade = CascadeType.ALL)
//    @OneToOne
//    @JoinColumn(name = "saving_account_id")
//    private SavingAccount savingAccount;

    @Override
    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount).add(BigDecimal.valueOf(5.0));
    }
}

