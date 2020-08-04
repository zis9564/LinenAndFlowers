package com.geleigeit.LinenAndFlowers.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "colours")
public class Colour {

    private long id;
    private String colour;
    private List<Fabric> fabrics = new ArrayList<>();
    private Date createdAt;
    private Date updatedAt = null;
    private Date deletedAt = null;

    public Colour() {
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @Id
    @JsonView(View.idName.class)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "colour_id", nullable = false, unique = true)
    public long getId() {
        return id;
    }

    @Column(name = "colour", unique = true)
    @JsonView(View.idName.class)
    public String getColour() {
        return colour;
    }

    @OneToMany(mappedBy = "colour", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH) //id
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
        Colour colour = (Colour) o;
        return id == colour.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "id= " + id + ", colour= '" + colour + '\'';
    }
}