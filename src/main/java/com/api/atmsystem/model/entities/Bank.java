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
@Table(name = "TB_BANK")
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private Long code;

    @Column(nullable = false)
    private String address;

//    @JsonIgnore
//    @OneToMany(mappedBy = "bank")
//    private Set<Account> accounts;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "atm_id")
//    private ATM atm;

    public void manages() {
        //implementacao do metodo manages
    }

    public void maintains() {
        //implementacao do metodo maintains
    }
}
