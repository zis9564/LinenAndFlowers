package com.geleigeit.LinenAndFlowers.entity.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.geleigeit.LinenAndFlowers.entity.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order_statuses")
public class OrderStatus extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    @Column(name = "status", nullable = false, unique = true)
    private String status;

    @OneToMany(mappedBy = "orderStatus", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JsonBackReference(value = "orderStatus-order")
    private Set<Order> orders = new HashSet<>();

    public OrderStatus() {
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
