package com.geleigeit.LinenAndFlowers.entity.tables.helpTables;

import com.geleigeit.LinenAndFlowers.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "fabric_count")
public class FabricCount extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    @Column(name = "length", nullable = false)
    private int length;

    @Column(name = "vendor_code", nullable = false)
    private String vendorCode;

    @Column(name = "item_name", nullable = false, unique = true)
    private String itemName;

    @Column(name = "size", nullable = false)
    private String size;

    public FabricCount() {
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}