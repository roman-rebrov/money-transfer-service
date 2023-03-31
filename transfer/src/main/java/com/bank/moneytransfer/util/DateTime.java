package com.bank.moneytransfer.util;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {


    public static String getDate() {
        return DateTimeFormatter.ofPattern("YY-MM-d").format(LocalDateTime.now());
    }

    public static String getTime() {
        return DateTimeFormatter.ofPattern("HH:mm").format(LocalDateTime.now());

    }
}
