package com.geleigeit.LinenAndFlowers.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "colour")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Colour extends AbstractEntity {

    @Column(name = "colour", unique = true)
    private String colour;

    @OneToMany(mappedBy = "colour", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Fabric> fabrics = new ArrayList<>();

    public Colour() {
    }

    public String getColour() {
        return colour;
    }

    public List<Fabric> getFabrics() {
        return fabrics;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setFabrics(List<Fabric> fabrics) {
        this.fabrics = fabrics;
    }
}