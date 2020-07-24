package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "types")
public class Type {

    private long id;
    private String type;
    private Boolean exist = true;
    private List<Fabric> fabrics = new ArrayList<>();

    public Type() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    public long getId() {
        return id;
    }

    @Column(name = "type", unique = true)
    public String getType() {
        return type;
    }

    @Column(name = "exist")
    public Boolean getExist() {
        return exist;
    }

    @OneToMany(mappedBy = "colour", cascade = CascadeType.REFRESH)
    public List<Fabric> getFabrics() {
        return fabrics;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setExist(Boolean exist) {
        this.exist = exist;
    }

    public void setFabrics(List<Fabric> fabrics) {
        this.fabrics = fabrics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type1 = (Type) o;
        return id == type1.id &&
                Objects.equals(type, type1.type) &&
                Objects.equals(exist, type1.exist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, exist);
    }

    @Override
    public String toString() {
        return "id= " + id + ", type= '" + type + '\'' + ", exist= " + exist;
    }
}
