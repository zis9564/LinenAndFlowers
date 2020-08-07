package com.geleigeit.LinenAndFlowers.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
@Table(name = "fabrics")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Fabric extends BaseEntity {

    @Column(name = "length", nullable = false)
    private int length;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "colour_id", nullable = false)
//    @JsonManagedReference
    private Colour colour;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "type_id", nullable = false)
//    @JsonManagedReference
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "thickness_id", nullable = false)
//    @JsonManagedReference
    private Thickness thickness;

    public Fabric() {
        super();
    }

    public int getLength() {
        return length;
    }

    public Colour getColour() {
        return colour;
    }

    public Type getType() {
        return type;
    }

    public Thickness getThickness() {
        return thickness;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setThickness(Thickness thickness) {
        this.thickness = thickness;
    }
}