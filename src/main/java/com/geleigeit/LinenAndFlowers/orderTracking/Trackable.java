package com.geleigeit.LinenAndFlowers.orderTracking;

import com.geleigeit.LinenAndFlowers.entity.tables.Order;
import com.jayway.jsonpath.PathNotFoundException;

import java.util.Date;

public interface Trackable {

    Order getOneByOrderId(long id);
    void getAllByDeliveryService();
    Order parser(Order order) throws PathNotFoundException;
    String getJson(String trackingNumber);
    Date convertStringToDate(String date);
    String normalizeString(String date, String time);
}
