package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "types")
public class Type extends BaseEntity{

    @Column(name = "type", unique = true)
    private String type;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH) //id
    private List<Fabric> fabrics = new ArrayList<>();

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt = null;

    @Column(name = "deleted_at")
    private Date deletedAt = null;

    public Type() {
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public String getType() {
        return type;
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

    public void setType(String type) {
        this.type = type;
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
        Type type1 = (Type) o;
        return Objects.equals(type, type1.type) &&
                Objects.equals(fabrics, type1.fabrics) &&
                Objects.equals(createdAt, type1.createdAt) &&
                Objects.equals(updatedAt, type1.updatedAt) &&
                Objects.equals(deletedAt, type1.deletedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fabrics, createdAt, updatedAt, deletedAt);
    }

    @Override
    public String toString() {
        return "Type{" +
                "type='" + type + '\'' +
                ", fabrics=" + fabrics +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
