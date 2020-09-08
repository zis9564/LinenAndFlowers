package com.geleigeit.LinenAndFlowers.entity.tables;

import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;
import com.geleigeit.LinenAndFlowers.entity.enums.SizeEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
public class Item extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //    @NotEmpty(message = "item.itemSize.emptyOrNull")
    @NotNull
    @Column(name = "size", nullable = false)
    @Enumerated(EnumType.STRING)
    private SizeEnum size;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "height", nullable = false)
    private Height height;

    //    @NotEmpty(message = "item.itemFabric.emptyOrNull")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fabric", nullable = false)
    private Fabric fabric;

    //    @NotEmpty(message = "item.itemName.emptyOrNull")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Item() {
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

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    public Product getItemName() {
        return product;
    }

    public void setItemName(Product product) {
        this.product = product;
    }
}