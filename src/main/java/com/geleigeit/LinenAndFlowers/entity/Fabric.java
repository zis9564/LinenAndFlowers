package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fabrics")
public class Fabric extends BaseEntity{

    @Column(name = "length", nullable = false)
    private int length;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "colour_id", nullable = false)
    private Colour colour;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "thickness_id", nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fabric fabric = (Fabric) o;
        return length == fabric.length &&
                Objects.equals(colour, fabric.colour) &&
                Objects.equals(type, fabric.type) &&
                Objects.equals(thickness, fabric.thickness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, colour, type, thickness);
    }

    @Override
    public String toString() {
        return "length=" + length + ", colour=" + colour + ", type=" + type + ", thickness=" + thickness;
    }
}