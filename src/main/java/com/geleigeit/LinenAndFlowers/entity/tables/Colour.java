package com.geleigeit.LinenAndFlowers.entity.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "colours")
public class Colour extends AbstractEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    @Size(min = 3, max = 32)
    @NotBlank
    @Column(name = "colour", unique = true, nullable = false)
    private String colour;

    @OneToMany(mappedBy = "colour", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JsonBackReference(value = "colour-fabric")
    private Set<Fabric> fabrics = new HashSet<>();

    public Colour() {
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Set<Fabric> getFabrics() {
        return fabrics;
    }

    public void setFabrics(Set<Fabric> fabrics) {
        this.fabrics = fabrics;
    }
}