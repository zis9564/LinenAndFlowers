package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "thickness")
public class Thickness extends BaseEntity{

    @Column(name = "thickness", unique = true)
    private int thickness;

    @OneToMany(mappedBy = "thickness", fetch = FetchType.EAGER, cascade = CascadeType.REFRESH) //id
    private List<Fabric> fabrics = new ArrayList<>();

    public Thickness() {}

    public int getThickness() {
        return thickness;
    }

    public List<Fabric> getFabrics() {
        return fabrics;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void setFabrics(List<Fabric> fabrics) {
        this.fabrics = fabrics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thickness thickness1 = (Thickness) o;
        return thickness == thickness1.thickness &&
                Objects.equals(fabrics, thickness1.fabrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(thickness, fabrics);
    }

    @Override
    public String toString() {
        return "thickness=" + thickness + ", fabrics=" + fabrics;
    }
}
