package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "colours")
public class Colour extends BaseEntity{

    @Column(name = "colour", unique = true)
    private String colour;

    @OneToMany(mappedBy = "colour", fetch = FetchType.EAGER, cascade = CascadeType.REFRESH) //id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colour colour1 = (Colour) o;
        return Objects.equals(colour, colour1.colour) &&
                Objects.equals(fabrics, colour1.fabrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour, fabrics);
    }

    @Override
    public String toString() {
        return "colour='" + colour + '\'' + ", fabrics=" + fabrics;
    }
}