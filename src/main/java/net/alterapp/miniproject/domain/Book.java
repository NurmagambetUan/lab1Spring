package net.alterapp.miniproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


import javax.persistence.*;

@Data
@Entity
@Component
@Table(name="book")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "seq",
        sequenceName = "s_book",
        initialValue = 1,
        allocationSize = 1
)
public class Book extends AuditModel{
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "genre")
    private String genre;
    @Column(name = "pagesamount")
    private String pagesamount;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "library")
    private Library library;
}

