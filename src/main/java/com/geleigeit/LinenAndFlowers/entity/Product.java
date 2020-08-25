package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "vendor_code", unique = true, nullable = false)
    private String vendorCode;

    @Column(name = "model_available", nullable = false)
    private Boolean isAvailable;

    @Column(name = "price", nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "discount_id")
    private Discount discount;

    public Product() {
    }

    public long getId() {
        return id;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public int getPrice() {
        return price;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
