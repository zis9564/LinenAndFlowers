package com.geleigeit.LinenAndFlowers.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "types")
public class Type {

    private long id;
    private String type;
    private List<Fabric> fabrics = new ArrayList<>();
    private Date createdAt;
    private Date updatedAt = null;
    private Date deletedAt = null;

    public Type() {
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @Id
    @JsonView(View.idName.class)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "type_id", nullable = false, unique = true)
    public long getId() {
        return id;
    }

    @Column(name = "type", unique = true)
    @JsonView(View.idName.class)
    public String getType() {
        return type;
    }

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH) //id
    @JsonIgnore
    public List<Fabric> getFabrics() {
        return fabrics;
    }

    @Column(name = "created_at", nullable = false)
    @JsonIgnore
    public Date getCreatedAt() {
        return this.createdAt;
    }

    @Column(name = "updated_at")
    @JsonIgnore
    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    @Column(name = "deleted_at")
    @JsonIgnore
    public Date getDeletedAt() {
        return this.deletedAt;
    }

    public void setId(long id) {
        this.id = id;
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
        return id == type1.id &&
                Objects.equals(type, type1.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return "id= " + id + ", type= '" + type;
    }
}
