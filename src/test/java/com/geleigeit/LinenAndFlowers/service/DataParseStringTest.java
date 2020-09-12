package com.geleigeit.LinenAndFlowers.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DataParseStringTest {

    private final String  date = "20200911";
    private final String time = "165146";
    private final String normalizedDate = normalizeString(date, time);

    @Test
    public void showParsedDate() {
        System.out.println(normalizedDate);
//        System.out.println(parseDate(normalizedDate));
    }

    private Date parseDate(String date) {

        try {
            return new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").parse(date);
        } catch (ParseException e) {
            System.out.println("cannot parse the string");
        }
        return null;
    }

    public String normalizeString(String date, String time) {

        final String dash = "-";
        final String colon = ":";
        final String space = " ";

        String buffer = date.substring(0, 4) +
                dash +
                date.substring(4, 6) +
                dash +
                date.substring(6) +
                space +
                time.substring(0, 2) +
                colon +
                time.substring(2, 4) +
                colon +
                time.substring(4);
        return buffer;
    }
}
