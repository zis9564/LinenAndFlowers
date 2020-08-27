package com.geleigeit.LinenAndFlowers.entity.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;
import com.geleigeit.LinenAndFlowers.entity.enums.SizeEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sizes")
public class Size extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "size", nullable = false)
    @Enumerated(EnumType.STRING)
    private SizeEnum size;

    @Column(name = "chest", nullable = false)
    private int chest;

    @Column(name = "waist", nullable = false)
    private int waist;

    @Column(name = "hips", nullable = false)
    private int hips;

    @Column(name = "height", nullable = false)
    private int height;

    @OneToMany(mappedBy = "size", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<FabricCount> fabricCounts = new ArrayList<>();

    @OneToMany(mappedBy = "size", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Item> items = new ArrayList<>();

    public Size() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SizeEnum getSize() {
        return size;
    }

    public void setSize(SizeEnum size) {
        this.size = size;
    }

    public int getChest() {
        return chest;
    }

    public void setChest(int chest) {
        this.chest = chest;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getHips() {
        return hips;
    }

    public void setHips(int hips) {
        this.hips = hips;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<FabricCount> getFabricCounts() {
        return fabricCounts;
    }

    public void setFabricCounts(List<FabricCount> fabricCounts) {
        this.fabricCounts = fabricCounts;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
