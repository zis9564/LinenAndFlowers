package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;

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
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "length", nullable = false)
    public int getLength() {
        return length;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    public Colour getColour() {
        return colour;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    public Type getType() {
        return type;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
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
    public String toString() {
        return "id=" + id + ", length=" + length + ", colour=" + colour + ", type=" + type + ", thickness=" + thickness;
    }
}