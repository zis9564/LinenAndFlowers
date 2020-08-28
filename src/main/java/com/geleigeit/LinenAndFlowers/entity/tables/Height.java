package com.geleigeit.LinenAndFlowers.entity.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "heights")
public class Height {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "height", nullable = false, unique = true)
    private String height;

    @OneToMany(mappedBy = "height", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @NotEmpty(message = "colour.colourFabrics.emptyOrNullValue")
    @JsonBackReference(value = "height-item")
    private List<Item> items = new ArrayList<>();

    public Height() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}