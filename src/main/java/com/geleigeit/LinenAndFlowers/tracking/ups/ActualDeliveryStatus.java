package com.geleigeit.LinenAndFlowers.tracking.ups;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class ActualDeliveryStatus {

    @NotNull
    private String trackingNumber;
    @NotNull
    private String city;
    @NotNull
    private String country;
    @NotNull
    private String status;
    @NotNull
    private String description;
    @NotNull
    private String date;

    public ActualDeliveryStatus() {
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ActualDeliveryStatus{" +
                "trackingNumber='" + trackingNumber + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
