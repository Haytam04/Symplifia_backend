package com.simplifia.Symplifia.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Data
@Entity
@Table(name = "resident")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResident")
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResident;

    @Column(nullable = false)
    private String fullName;

    @Column(
            nullable = false,
            unique = true
    )
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "idBuilding")
    private Building building;

    @OneToMany(mappedBy = "resident")
    private List<Invoice> invoices;

}
