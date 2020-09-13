package com.geleigeit.LinenAndFlowers.entity.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "thickness")
public class Thickness extends AbstractEntity {

    @NotNull
    @Range(min=80, max=350)
    @Column(name = "thickness", unique = true, nullable = false)
    private int thickness;

    @OneToMany(mappedBy = "thickness", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JsonBackReference(value = "thickness-fabric")
    private Set<Fabric> fabrics = new HashSet<>();

    public Thickness() {}

    public int getThickness() {
        return thickness;
    }

    public Set<Fabric> getFabrics() {
        return fabrics;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void setFabrics(Set<Fabric> fabrics) {
        this.fabrics = fabrics;
    }
}
