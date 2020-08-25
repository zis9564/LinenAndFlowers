package com.geleigeit.LinenAndFlowers.entity;

import com.geleigeit.LinenAndFlowers.entity.enums.Size;

import javax.persistence.*;

@Entity
@Table(name = "fabric_count")
public class FabricCount extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "vendor_code")
    private Product vendorCode;

    @Column(name = "size")
    @Enumerated(EnumType.STRING)
    private Size size;

    @Column(name = "length", nullable = false)
    private int length;

    public FabricCount() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(Product vendorCode) {
        this.vendorCode = vendorCode;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
