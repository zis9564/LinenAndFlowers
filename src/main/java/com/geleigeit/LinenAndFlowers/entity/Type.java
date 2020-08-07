package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "types")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Type extends BaseEntity {

    @Column(name = "type", unique = true)
    private String type;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonBackReference
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
}
