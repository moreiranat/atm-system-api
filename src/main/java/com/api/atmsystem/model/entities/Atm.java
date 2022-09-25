package com.api.atmsystem.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_ATM")
public class Atm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String managedby;

//    @JsonIgnore
//    @OneToMany(mappedBy = "atm")
//    private Set<Bank> banks;
//
//    @OneToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer;

    public void identifies() {
        //implementacao do metodo identifies
    }

    public void transactions() {
        //implementacao do metodo transactions
    }
}

