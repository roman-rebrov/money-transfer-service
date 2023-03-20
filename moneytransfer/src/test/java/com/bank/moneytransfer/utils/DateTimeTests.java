package com.bank.moneytransfer.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeTests {

    @Test
    @DisplayName("Date test")
    public void dateTest(){

        String date = DateTimeFormatter.ofPattern("YY-MM-dd").format(LocalDateTime.now());
        String dateResult = DateTime.getDate();

        Assertions.assertEquals(date, dateResult);
    }

    @Test
    @DisplayName("Time test")
    public void timeTest(){

        String time = DateTimeFormatter.ofPattern("HH:mm").format(LocalDateTime.now());
        String timeResult = DateTime.getTime();

        Assertions.assertEquals(time, timeResult);
    }
}
