package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fabrics")
public class Fabric {

    private long id;
    private int length;
    private Colour colour;
    private Type type;
    private Thickness thickness;

    public Fabric() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    @Column(name = "length", nullable = false)
    public int getLength() {
        return length;
    }

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    public Colour getColour() {
        return colour;
    }

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    public Type getType() {
        return type;
    }

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    public Thickness getThickness() {
        return thickness;
    }

    public void setId(long id) {
        this.id = id;
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
        return id == fabric.id &&
                Objects.equals(colour, fabric.colour) &&
                Objects.equals(type, fabric.type) &&
                Objects.equals(thickness, fabric.thickness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, colour, type, thickness);
    }

    @Override
    public String toString() {
        return "id= " + id + ", colour= " + colour + ", type =" + type + ", thickness =" + thickness;
    }
}
