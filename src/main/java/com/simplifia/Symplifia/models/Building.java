package com.simplifia.Symplifia.models;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "building")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idBuilding")
//@JsonIgnoreProperties({"syndic", "residents"})
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBuilding;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal syndicPrice;

    @Column(nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "idSyndic")
    private Syndic syndic;

    @OneToMany(mappedBy = "building")
    private List<Resident> residents;
}
