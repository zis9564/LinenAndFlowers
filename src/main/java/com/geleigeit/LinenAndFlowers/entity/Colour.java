package com.geleigeit.LinenAndFlowers.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "colour")
public class Colour extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 3, max = 32)
    @NotBlank(message = "colour.colourName.wrongLength")
    @Column(name = "colour", unique = true)
    private String colour;

    @OneToMany(mappedBy = "colour", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Fabric> fabrics = new ArrayList<>();

    public Colour() {
    }

    public long getId() {
        return id;
    }

    public String getColour() {
        return colour;
    }

    public List<Fabric> getFabrics() {
        return fabrics;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setFabrics(List<Fabric> fabrics) {
        this.fabrics = fabrics;
    }
}