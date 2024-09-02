package com.simplifia.Symplifia.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "expense")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idExpense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExpense;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal cost;

    private String description;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE) // This ensures the date is stored as a DATE type in SQL, not DATETIME
    private Date date;

    @ManyToOne
    @JoinColumn(name = "idSyndic")
    private Syndic syndic;

}
