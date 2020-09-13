package com.geleigeit.LinenAndFlowers.entity.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.geleigeit.LinenAndFlowers.entity.AbstractEntity;
import com.geleigeit.LinenAndFlowers.entity.tables.helpTables.Country;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address extends AbstractEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    @Size(min = 3, max = 255)
    @NotBlank
    @Column(name = "address", nullable = false)
    private String address;

    @Size(min = 5, max = 13)
    @NotBlank
    @Column(name = "postcode", nullable = false)
    private String postcode;

    @Size(min = 3, max = 64)
    @NotBlank
    @Column(name = "city", nullable = false)
    private String city;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JsonBackReference(value = "address-order")
    private Set<Order> orders = new HashSet<>();

    public Address() {
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
