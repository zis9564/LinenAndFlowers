package com.geleigeit.LinenAndFlowers.orderTracking;

import com.geleigeit.LinenAndFlowers.entity.tables.Order;
import com.jayway.jsonpath.PathNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface Trackable {

    @Transactional
    Order getOneByOrderId(long id);
    @Transactional
    void getAllByDeliveryService();
    @Transactional
    Order parser(Order order) throws PathNotFoundException;
    String getJson(String trackingNumber);
    Date convertStringToDate(String date);
    String normalizeString(String date, String time);
}
