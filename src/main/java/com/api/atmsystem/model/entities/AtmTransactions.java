package com.api.atmsystem.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_ATM_TRANSACTIONS")
public class AtmTransactions implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name = "date_transaction")
    private LocalDate date;

    @Column(name = "type_transaction", nullable = false)
    private String type;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private BigDecimal postBalance;

//    @ManyToOne
//    @JoinColumn(name = "account_id")
//    private Account account;

    public void modifies(String type) {
        //implementacao do metodo modifies
    }
}