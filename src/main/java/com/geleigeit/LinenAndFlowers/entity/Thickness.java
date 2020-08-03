package com.geleigeit.LinenAndFlowers.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "thickness")
public class Thickness {

    private long id;
    private int thickness;
    private List<Fabric> fabrics = new ArrayList<>();
    private Date createdAt;
    private Date updatedAt = null;
    private Date deletedAt = null;

    public Thickness() {}

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @Id
    @JsonView(View.idName.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "thickness_id", nullable = false, unique = true)
    public long getId() {
        return id;
    }

    @Column(name = "thickness", unique = true)
    @JsonView(View.idName.class)
    public int getThickness() {
        return thickness;
    }

    @OneToMany(mappedBy = "id", cascade = CascadeType.REFRESH)
    public List<Fabric> getFabrics() {
        return fabrics;
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
        return id == thickness1.id &&
                thickness == thickness1.thickness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, thickness);
    }

    @Override
    public String toString() {
        return "id= " + id + ", thickness= " + thickness;
    }
}
