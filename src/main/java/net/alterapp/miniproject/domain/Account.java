package net.alterapp.miniproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


import javax.persistence.*;

@Data
@Entity
@Component
@Table(name="labWork")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "seq",
        sequenceName = "s_account",
        initialValue = 1,
        allocationSize = 1
)
public class Account extends AuditModel{
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "card_number")
    private int cardNumber;
    @Column(name = "pin")
    private int pin;
    @Column(name = "balance")
    private int balance = 0;
    @Column(name = "withdraw")
    private int withdraw;
    @Column(name = "top_up")
    private int topUp;

}
