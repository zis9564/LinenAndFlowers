package com.geleigeit.LinenAndFlowers.entity.tables;

import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "fabrics")
public class Fabric extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @PositiveOrZero(message = "fabric.fabricLength.negativeValue")
//    @NotEmpty(message = "fabric.fabricLength.wrongValue")
    @Column(name = "length", nullable = false)
    private int length;

//    @NotEmpty(message = "fabric.fabricColour.emptyOrNullValue")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "colour_id", nullable = false)
    private Colour colour;

//    @NotEmpty(message = "fabric.fabricType.emptyOrNullValue")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

//    @NotEmpty(message = "fabric.fabricThickness.emptyOrNullValue")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "thickness_id", nullable = false)
    private Thickness thickness;

    public Fabric() {
    }

    public long getId() {
        return id;
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
}