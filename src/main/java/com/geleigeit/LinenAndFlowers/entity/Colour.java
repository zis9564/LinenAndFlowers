package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "colours")
public class Colour {

    private long id;
    private String colour;
    private Boolean exist = true;
    private List<Fabric> fabrics = new ArrayList<>();

    public Colour() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    public long getId() {
        return id;
    }

    @Column(name = "colour", unique = true)
    public String getColour() {
        return colour;
    }

    @Column(name = "exist")
    public Boolean getExist() {
        return exist;
    }

    @OneToMany(mappedBy = "colour", cascade = CascadeType.REFRESH)
    public List<Fabric> getFabrics() {
        return fabrics;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setExist(Boolean exist) {
        this.exist = exist;
    }

    public void setFabrics(List<Fabric> fabrics) {
        this.fabrics = fabrics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colour colour1 = (Colour) o;
        return id == colour1.id &&
                Objects.equals(colour, colour1.colour) &&
                Objects.equals(exist, colour1.exist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, colour, exist);
    }

    @Override
    public String toString() {
        return "id= " + id + ", colour= '" + colour + '\'' + ", exist= " + exist;
    }
}