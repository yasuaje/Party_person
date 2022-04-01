package com.asuajeyeison.personparty.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "habilities")
public class Hability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hability_id", nullable = false)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    @ManyToOne
    @JoinColumn(name ="person_id")
    @JsonBackReference
    private Person person;

}