package com.geleigeit.LinenAndFlowers.tracking.ups;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;

@Component
public class UpsDeliveryConnector {

    public String getResponse() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("AccessLicenseNumber", "7D874B3DE6305751");
        HttpEntity<String> request=new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://onlinetools.ups.com/track/v1/details/"+"Y0081040191";
//        HttpEntity header = customHeader();

        ResponseEntity responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return (String) responseEntity.getBody();
    }

    public void parser() throws IOException {
        String json = getResponse();
        JsonFactory jfactory = new JsonFactory();
        JsonParser jParser = jfactory.createParser(json);

        String trackingNumber = null;
        String city = null;
        String country = null;
        String description = null;
        String date = null;

        while (jParser.nextToken() != JsonToken.END_ARRAY) {
            String fieldname = jParser.getCurrentName();
            if ("trackingNumber".equals(fieldname)) {
                jParser.nextToken();
                trackingNumber = jParser.getText();
            }

            if ("description".equals(fieldname)) {
                jParser.nextToken();
                description = jParser.getText();
            }

            if ("date".equals(fieldname)) {
                jParser.nextToken();
                date = jParser.getText();
            }

            if ("city".equals(fieldname)) {
                jParser.nextToken();
                city = jParser.getText();
            }

            if ("country".equals(fieldname)) {
                jParser.nextToken();
                country = jParser.getText();
            }
        }
        jParser.close();

        System.out.println(trackingNumber + city + country + description + date);
    }
}
