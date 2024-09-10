package com.simplifia.Symplifia.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
