package com.api.atmsystem.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CUSTOMER")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true, length = 30)
    private String cardNumber;

    @Column(nullable = false, length = 30)
    @Getter(onMethod = @__({@JsonIgnore}))
    @Setter(onMethod = @__({@JsonProperty}))
    private String pin;

    @Column(nullable = false, unique = true, length = 11)
    @CPF
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER) //um cliente pode ter varias contas
    private Set<Account> accounts;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "atm_id")
//    private ATM atm;

    public void verifyPassword(String pin) {
        if (pin != null){
            if(this.pin.equals(pin)) {
                System.out.println("Sua senha está correta!");
            } else {
                System.out.println("Sua senha está incorreta. Digite novamente!");
            }
        } else {
            System.out.println("Cadastre um pin!");
        }
    }
}
