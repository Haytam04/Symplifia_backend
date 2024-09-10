package com.simplifia.Symplifia.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.util.Date;

@Data
@Entity
@Table(name = "invoice")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idInvoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInvoice;

    @Column(nullable = false)
    private Month invoiceMonth;

    @Column(nullable = false)
    private Year invoiceYear;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatue paymentStatue;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "idSyndic")
    private Syndic syndic;

    @ManyToOne
    @JoinColumn(name = "idResident")
    private Resident resident;

}
