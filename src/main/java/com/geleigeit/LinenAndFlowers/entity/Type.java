package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "fabric_type")
public class Type {

    private long id;
    private String type;
    private Set<Fabric> fabrics = new HashSet<>();

    public Type() {
    }

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    public Set<Fabric> getFabrics() {
        return fabrics;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFabrics(Set<Fabric> fabrics) {
        this.fabrics = fabrics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return id == type.id &&
                Objects.equals(fabrics, type.fabrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fabrics);
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", fabrics=" + fabrics +
                '}';
    }
}

