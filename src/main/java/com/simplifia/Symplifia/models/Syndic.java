package com.simplifia.Symplifia.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "syndic")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idSyndic")
public class Syndic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSyndic;

    @Column(nullable = false)
    private String fullName;

    @Column(
            nullable = false,
            unique = true
    )
    private String phoneNumber;

    @Column(nullable = false)
    private String bankName;

    @Column(
            nullable = false,
            unique = true
    )
    private String bankAccount;

    @Column(nullable = false)
    private Date inscriptionDate;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @OneToMany(mappedBy = "syndic")
    @JsonIgnore
    private List<Building> buildings;

    @OneToMany(mappedBy = "syndic")
    @JsonIgnore
    private List<Expense> expenses;

    @OneToMany(mappedBy = "syndic")
    @JsonIgnore
    private List<Invoice> invoices;

}
