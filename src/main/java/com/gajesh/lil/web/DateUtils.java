package com.gajesh.lil.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Handle Str and Date Objects

public class DateUtils {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date getDateFromDateString(String dateStr){
        Date date = null;

        if(dateStr != null){
            try {
                date =  DATE_FORMAT.parse(dateStr);
            }
            catch (ParseException pe){
                date = new Date();
            }
        }
        else{
            date = new Date();
        }
    return  date;
    }

}
