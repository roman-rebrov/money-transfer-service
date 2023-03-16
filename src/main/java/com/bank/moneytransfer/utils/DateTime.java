package com.bank.moneytransfer.utils;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {


    public static String getDate(){
        return DateTimeFormatter.ofPattern("YY-MM-d").format(ZonedDateTime.now());
    }

    public static String getTime(){
        return DateTimeFormatter.ofPattern("HH:mm").format(ZonedDateTime.now());

    }
}
