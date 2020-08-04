package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.Date;
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

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt = null;

    @Column(name = "deleted_at")
    private Date deletedAt = null;

    public Fabric() {
        super();
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
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

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public Date getDeletedAt() {
        return this.deletedAt;
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
        return length == fabric.length &&
                Objects.equals(colour, fabric.colour) &&
                Objects.equals(type, fabric.type) &&
                Objects.equals(thickness, fabric.thickness) &&
                Objects.equals(createdAt, fabric.createdAt) &&
                Objects.equals(updatedAt, fabric.updatedAt) &&
                Objects.equals(deletedAt, fabric.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, colour, type, thickness, createdAt, updatedAt, deletedAt);
    }

    @Override
    public String toString() {
        return "Fabric{" +
                "length=" + length +
                ", colour=" + colour +
                ", type=" + type +
                ", thickness=" + thickness +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}