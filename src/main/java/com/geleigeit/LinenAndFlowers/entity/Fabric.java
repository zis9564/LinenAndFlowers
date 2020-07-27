package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "fabrics")
public class Fabric {

    private long id;
    private int length;
    private Colour colour;
    private Type type;
    private Thickness thickness;
    private Date createdAt;
    private Date updatedAt = null;
    private Date deletedAt = null;

    public Fabric() {
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fabric_id", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    @Column(name = "length", nullable = false)
    public int getLength() {
        return length;
    }

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "colour_id", nullable = false)
    public Colour getColour() {
        return colour;
    }

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    public Type getType() {
        return type;
    }

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "thickness_id", nullable = false)
    public Thickness getThickness() {
        return thickness;
    }

    @Column(name = "created_at", nullable = false)
    public Date getCreatedAt() {
        return this.createdAt;
    }

    @Column(name = "updated_at")
    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    @Column(name = "deleted_at")
    public Date getDeletedAt() {
        return this.deletedAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLength(int length) {
        this.length = length;
    }

//    public void setColour(Colour colour) {
//        setColour(colour, true);
//    }
//
//    void setColour(Colour colour, Boolean add) {
//        this.colour = colour;
//        if(colour != null && add) {
//            colour.addFabric(this, false);
//        }
//    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setThickness(Thickness thickness) {
        this.thickness = thickness;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
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
