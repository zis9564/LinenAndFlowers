package com.geleigeit.LinenAndFlowers.entity.tables;

import com.geleigeit.LinenAndFlowers.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "order_tracking_details")
public class OrderTracking extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    @Size(min = 11, max = 14)
    @NotBlank
    @Column(name = "tracking_code", nullable = false, updatable = false)
    private String trackingCode;

    @Size(min = 3, max = 255)
    @NotBlank
    @Column(name = "description", nullable = false)
    private String description;

    @Size(min = 2, max = 2)
    @NotBlank
    @Column(name = "current_country", updatable = false)
    private String currentCountry;

    @Size(min = 2, max = 255)
    @NotBlank
    @Column(name = "current_city", updatable = false)
    private String currentCity;

    @NotNull
    @Column(name = "date", nullable = false, updatable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public OrderTracking() {
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrentCountry() {
        return currentCountry;
    }

    public void setCurrentCountry(String currentCountry) {
        this.currentCountry = currentCountry;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
