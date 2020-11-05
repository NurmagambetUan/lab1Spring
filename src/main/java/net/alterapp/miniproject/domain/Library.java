package net.alterapp.miniproject.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="library")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "seq",
        sequenceName = "s_library",
        initialValue = 1,
        allocationSize = 1
)
public class Library extends AuditModel{
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "city")
    private String city;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "library")
    private List<Book> book;
}
