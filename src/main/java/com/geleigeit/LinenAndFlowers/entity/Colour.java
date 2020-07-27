package com.geleigeit.LinenAndFlowers.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "colour_id", nullable = false, unique = true)
    public long getId() {
        return id;
    }

    @Column(name = "colour", unique = true)
    public String getColour() {
        return colour;
    }

    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
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

//    public void addFabric(Fabric fabric) {
//        addFabric(fabric, true);
//    }
//
//    void addFabric(Fabric fabric, Boolean set) {
//        if(fabric != null) {
//            if(getFabrics().contains(fabric)) {
//                getFabrics().set(getFabrics().indexOf(fabric), fabric);
//            }
//            else {
//                getFabrics().add(fabric);
//            }
//            if(set) {
//                fabric.setColour(this, false);
//            }
//        }
//    }
//
//    public void removeFabric(Fabric fabric) {
//        getFabrics().remove(fabric);
//        fabric.setColour(null);
//    }

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
        Colour colour1 = (Colour) o;
        return id == colour1.id &&
                Objects.equals(colour, colour1.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, colour);
    }

    @Override
    public String toString() {
        return "id= " + id + ", colour= '" + colour + '\'';
    }
}