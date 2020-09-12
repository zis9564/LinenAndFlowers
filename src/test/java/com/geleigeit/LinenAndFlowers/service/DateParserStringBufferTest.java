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
public class DateParserStringBufferTest {

    private final String  date = "2020-09-11";
    private final String time = "16:51:46";
    private final String normalizedDate = normalizeString(date, time);

    @Test
    public void showParsedDate() {
        System.out.println(parseDate(normalizedDate));
    }

    private Date parseDate(String date) {

        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
        } catch (ParseException e) {
            System.out.println("cannot parse the string");
        }
        return null;
    }

    private String normalizeString(String date, String time) {

        final String dash = "-";
        final String colon = ":";
        final String space = " ";

        StringBuffer buffer = new StringBuffer(19);

        buffer.append(date, 0, 4);
        buffer.append(dash);
        buffer.append(date, 5, 7);
        buffer.append(dash);
        buffer.append(date, 8, 10);
        buffer.append(space);
        buffer.append(time, 0, 2);
        buffer.append(colon);
        buffer.append(time, 3, 5);
        buffer.append(colon);
        buffer.append(time, 6, 8);
        return buffer.toString();
    }
}
