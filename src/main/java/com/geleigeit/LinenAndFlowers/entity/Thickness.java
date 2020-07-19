package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "thicknesses")
public class Thickness {

    private long id;
    private int thickness;
    private Set<Fabric> fabrics = new HashSet<>();

    public Thickness() {
    }

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "thickness")
    public int getThickness() {
        return thickness;
    }

    @OneToMany(mappedBy = "thickness", cascade = CascadeType.ALL)
    public Set<Fabric> getFabrics() {
        return fabrics;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void setFabrics(Set<Fabric> fabrics) {
        this.fabrics = fabrics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thickness thickness = (Thickness) o;
        return id == thickness.id &&
                Objects.equals(fabrics, thickness.fabrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fabrics);
    }

    @Override
    public String toString() {
        return "Thickness{" +
                "id=" + id +
                ", fabrics=" + fabrics +
                '}';
    }
}
