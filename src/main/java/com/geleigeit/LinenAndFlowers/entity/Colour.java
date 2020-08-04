package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "colours")
public class Colour extends BaseEntity{

    @Column(name = "colour", unique = true)
    private String colour;

    @OneToMany(mappedBy = "colour", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH) //id
    private List<Fabric> fabrics = new ArrayList<>();

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt = null;

    @Column(name = "deleted_at")
    private Date deletedAt = null;

    public Colour() {
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public String getColour() {
        return colour;
    }

    public List<Fabric> getFabrics() {
        return fabrics;
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

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setFabrics(List<Fabric> fabrics) {
        this.fabrics = fabrics;
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
        Colour colour1 = (Colour) o;
        return Objects.equals(colour, colour1.colour) &&
                Objects.equals(fabrics, colour1.fabrics) &&
                Objects.equals(createdAt, colour1.createdAt) &&
                Objects.equals(updatedAt, colour1.updatedAt) &&
                Objects.equals(deletedAt, colour1.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour, fabrics, createdAt, updatedAt, deletedAt);
    }

    @Override
    public String toString() {
        return "Colour{" +
                "colour='" + colour + '\'' +
                ", fabrics=" + fabrics +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}