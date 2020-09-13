package com.geleigeit.LinenAndFlowers.entity.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "types")
public class Type extends AbstractEntity {

    @Size(min = 3, max = 32)
    @NotBlank
    @Column(name = "type", unique = true, nullable = false)
    private String type;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JsonBackReference(value = "type-fabric")
    private Set<Fabric> fabrics = new HashSet<>();

    public Type() {
    }

    public String getType() {
        return type;
    }

    public Set<Fabric> getFabrics() {
        return fabrics;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFabrics(Set<Fabric> fabrics) {
        this.fabrics = fabrics;
    }
}
