package com.geleigeit.LinenAndFlowers.entity.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends AbstractEntity {

    @Size(min = 3, max = 16)
    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min = 7, max = 16)
    @NotBlank
    @Column(name = "vendor_code", nullable = false, unique = true)
    private String vendorCode;

    @Size(min = 10, max = 255)
    @Column(name = "blueprint_root")
    private String blueprintRoot;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JsonBackReference(value = "product-item")
    private Set<Item> items = new HashSet<>();

    public Product() {
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

    public String getBlueprintRoot() {
        return blueprintRoot;
    }

    public void setBlueprintRoot(String blueprintRoot) {
        this.blueprintRoot = blueprintRoot;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
