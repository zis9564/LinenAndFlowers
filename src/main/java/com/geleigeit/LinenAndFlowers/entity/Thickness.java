package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "thickness")
public class Thickness extends BaseEntity{

    @Column(name = "thickness", unique = true)
    private int thickness;

    @OneToMany(mappedBy = "thickness", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH) //id
    private List<Fabric> fabrics = new ArrayList<>();

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt = null;

    @Column(name = "deleted_at")
    private Date deletedAt = null;

    public Thickness() {}

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }


    public int getThickness() {
        return thickness;
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

    public void setThickness(int thickness) {
        this.thickness = thickness;
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
        Thickness thickness1 = (Thickness) o;
        return thickness == thickness1.thickness &&
                Objects.equals(fabrics, thickness1.fabrics) &&
                Objects.equals(createdAt, thickness1.createdAt) &&
                Objects.equals(updatedAt, thickness1.updatedAt) &&
                Objects.equals(deletedAt, thickness1.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(thickness, fabrics, createdAt, updatedAt, deletedAt);
    }

    @Override
    public String toString() {
        return "Thickness{" +
                "thickness=" + thickness +
                ", fabrics=" + fabrics +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
