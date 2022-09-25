package com.api.atmsystem.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SavingAccount extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    //@MapsId
//    @OneToOne
//    @JoinColumn(name = "current_account_id")
//    private CurrentAccount currentAccount;
}