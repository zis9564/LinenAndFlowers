package com.geleigeit.LinenAndFlowers.entity.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.geleigeit.LinenAndFlowers.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "heights")
public class Height extends BaseEntity {

    @Column(name = "height", nullable = false, unique = true)
    private String height;

    @OneToMany(mappedBy = "height", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @NotEmpty
    @JsonBackReference(value = "height-item")
    private Set<Item> items = new HashSet<>();

    public Height() {
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}