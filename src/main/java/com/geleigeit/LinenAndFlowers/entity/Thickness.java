package com.geleigeit.LinenAndFlowers.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "thickness")
public class Thickness extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "thickness", unique = true)
    private int thickness;

    @OneToMany(mappedBy = "thickness", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Fabric> fabrics = new ArrayList<>();

    public Thickness() {}

    public long getId() {
        return id;
    }

    public int getThickness() {
        return thickness;
    }

    public List<Fabric> getFabrics() {
        return fabrics;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void setFabrics(List<Fabric> fabrics) {
        this.fabrics = fabrics;
    }
}
