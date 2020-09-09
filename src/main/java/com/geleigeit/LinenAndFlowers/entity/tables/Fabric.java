package com.geleigeit.LinenAndFlowers.entity.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fabrics")
public class Fabric extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Min(1)
    @Column(name = "length", nullable = false)
    private int length;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "colour_id", nullable = false)
    private Colour colour;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "thickness_id", nullable = false)
    private Thickness thickness;

    @OneToMany(mappedBy = "fabric", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JsonBackReference(value = "fabric-item")
    private List<Item> items = new ArrayList<>();

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

    public List<Item> getItems() {
        return items;
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

    public void setItems(List<Item> items) {
        this.items = items;
    }
}