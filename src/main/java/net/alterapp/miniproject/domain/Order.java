package net.alterapp.miniproject.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_order")
@SequenceGenerator(
        name = "seq",
        sequenceName = "s_order",
        initialValue = 1,
        allocationSize = 1
)
public class Order extends AuditModel {
    @Column(name = "date")
    private Date date;
    @Column(name = "passingdate")
    private Date passingDate;
    @Column(name = "passeddate")
    private Date passedDate;
    @ManyToOne
    private Library library;
    @ManyToOne
    private Book book;
    @ManyToOne
    private Customer customer;

}
