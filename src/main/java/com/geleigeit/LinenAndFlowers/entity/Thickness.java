package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "thickness")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Thickness extends BaseEntity {

    @Column(name = "thickness", unique = true)
    private int thickness;

    @OneToMany(mappedBy = "thickness", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonBackReference
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
}
