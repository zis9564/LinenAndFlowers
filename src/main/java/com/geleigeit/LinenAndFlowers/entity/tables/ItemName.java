package com.geleigeit.LinenAndFlowers.entity.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item_names")
public class ItemName extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 3, max = 16)
    @NotBlank(message = "itemName.name.wrongLength")
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min = 3, max = 4)//check
    @NotBlank(message = "itemName.vendorCode.wrongLength")
    @Column(name = "vendor_code", nullable = false, unique = true)
    private String vendorCode;

//    @NotEmpty(message = "itemName.items.emptyOrNull")
    @OneToMany(mappedBy = "itemName", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JsonBackReference(value = "itemName-item")
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}