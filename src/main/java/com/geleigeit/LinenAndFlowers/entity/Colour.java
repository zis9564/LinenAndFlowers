package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;

@Entity
@Table(name = "colours")
public class Colour {


    private long id;

    private String colour;

//    private Set<Fabric> fabrics = new HashSet<>();

    public Colour() {
    }

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "colour", unique = true)
    public String getColour() {
        return colour;
    }

//    @OneToMany(mappedBy = "colour", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    public Set<Fabric> getFabrics() {
//        return fabrics;
//    }

    public void setId(long id) {
        this.id = id;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

//    public void setFabrics(Set<Fabric> fabrics) {
//        this.fabrics = fabrics;
//    }

//    @Override
//    public String toString() {
//        return "id=" + id + ", fabrics=" + fabrics;
//    }
}