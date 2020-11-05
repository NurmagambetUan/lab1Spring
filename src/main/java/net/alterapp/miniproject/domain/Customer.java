package net.alterapp.miniproject.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "seq",
        sequenceName = "s_customer",
        initialValue = 1,
        allocationSize = 1
)

public class Customer extends AuditModel{
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "age")
    private String age;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "country")
    private String country;
}
