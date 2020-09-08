package com.geleigeit.LinenAndFlowers.tracking.ups;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UpsDeliveryConnector {



    public String getResponse() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("AccessLicenseNumber", "7D874B3DE6305751");
        HttpEntity<String> request=new HttpEntity<String>(headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://onlinetools.ups.com/track/v1/details/"+"Y008104021";
//        HttpEntity header = customHeader();

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return responseEntity.getBody();
    }

    public void parser() {
        String json = getResponse();
        ActualDeliveryStatus entity = new ActualDeliveryStatus();

        String[] jsonPaths = new String[6];
        jsonPaths[0] = "$.trackResponse.shipment[*].package[*].trackingNumber";
        jsonPaths[1] = "$.trackResponse.shipment[*].package[*].activity[*].location.address.city";
        jsonPaths[2] = "$.trackResponse.shipment[*].package[*].activity[*].location.address.country";
        jsonPaths[3] = "$.trackResponse.shipment[*].package[*].activity[*].status.type";
        jsonPaths[4] = "$.trackResponse.shipment[*].package[*].activity[*].status.description";
        jsonPaths[5] = "$.trackResponse.shipment[*].package[*].activity[*].date";
    }
}
