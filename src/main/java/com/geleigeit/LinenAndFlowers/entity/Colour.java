package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "colours")
public class Colour {

    private long id;
    private String colour;
    private Boolean exist = true;

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

    public void setId(long id) {
        this.id = id;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setExist(Boolean exist) {
        exist = exist;
    }

    //    public void setFabrics(Set<Fabric> fabrics) {
//        this.fabrics = fabrics;
//    }


    @Override
    public String toString() {
        return "id= " + id + ", colour= '" + colour + '\'' + ", exist= " + exist;
    }
}