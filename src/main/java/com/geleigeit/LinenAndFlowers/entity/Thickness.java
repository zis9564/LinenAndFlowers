package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "thickness")
public class Thickness {

    private long id;
    private int thickness;
    private Boolean exist = true;
    private List<Fabric> fabrics = new ArrayList<>();

    public Thickness() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    public long getId() {
        return id;
    }

    @Column(name = "thickness", unique = true)
    public int getThickness() {
        return thickness;
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

    public void setThickness(int thickness) {
        this.thickness = thickness;
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
        Thickness thickness1 = (Thickness) o;
        return id == thickness1.id &&
                thickness == thickness1.thickness &&
                Objects.equals(exist, thickness1.exist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, thickness, exist);
    }

    @Override
    public String toString() {
        return "id= " + id + ", thickness= " + thickness + ", exist= " + exist;
    }
}
