package com.asuajeyeison.personparty.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false)
    private Long id;
    private String name;
    private int age;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private Set<Hability> habilities = new HashSet<>();

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "person_party",
            joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "party_id", referencedColumnName = "party_id"))
    private Set<Party> partys = new HashSet<>();


}