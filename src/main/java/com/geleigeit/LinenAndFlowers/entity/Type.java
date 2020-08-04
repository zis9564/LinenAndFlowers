package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "types")
public class Type extends BaseEntity{

    @Column(name = "type", unique = true)
    private String type;

    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER, cascade = CascadeType.REFRESH) //id
    private List<Fabric> fabrics = new ArrayList<>();

    public Type() {
    }

    public String getType() {
        return type;
    }

    public List<Fabric> getFabrics() {
        return fabrics;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFabrics(List<Fabric> fabrics) {
        this.fabrics = fabrics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type1 = (Type) o;
        return Objects.equals(type, type1.type) &&
                Objects.equals(fabrics, type1.fabrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fabrics);
    }

    @Override
    public String toString() {
        return "type='" + type + '\'' + ", fabrics=" + fabrics;
    }
}
