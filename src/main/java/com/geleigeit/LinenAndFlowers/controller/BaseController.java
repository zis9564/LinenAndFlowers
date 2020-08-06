package com.geleigeit.LinenAndFlowers.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BaseController {

    private static final Logger logger = LogManager.getLogger(BaseController.class);
    private final static int MIN_LENGTH = 3;
    private final static int FABRIC_LENGTH = 10;

    void stringLengthChecker(String string) {
        if(string.length() < MIN_LENGTH) {
            logger.error("String length is to short");
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "String cannot be less than " + MIN_LENGTH + " char");
        }
    }

    void minFabricLengthChecker(int value) {
        if(value <= FABRIC_LENGTH) {
            logger.error("Fabric is to short");
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Fabric cannot be shorter than " + FABRIC_LENGTH + "centimeters");
        }
    }
}
