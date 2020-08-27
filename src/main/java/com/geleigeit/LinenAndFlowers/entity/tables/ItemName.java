package com.geleigeit.LinenAndFlowers.entity.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item_names")
public class ItemName extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "vendor_code", nullable = false)
    private String vendorCode;

    @OneToMany(mappedBy = "itemName", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<FabricCount> fabricCountList = new ArrayList<>();

    @OneToMany(mappedBy = "itemName", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Item> items = new ArrayList<>();

    public ItemName() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public List<FabricCount> getFabricCountList() {
        return fabricCountList;
    }

    public void setFabricCountList(List<FabricCount> fabricCountList) {
        this.fabricCountList = fabricCountList;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
