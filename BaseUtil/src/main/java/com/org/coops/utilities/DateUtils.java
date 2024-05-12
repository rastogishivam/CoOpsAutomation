package com.org.coops.utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String getCurrentDay(){
        LocalDate currentDate = LocalDate.now();
        String dayOfMonth = String.valueOf(currentDate.getDayOfMonth());
        return dayOfMonth;
    }
    public static String getCurrentDateWithTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String formattedDateTime = now.format(formatter);
        return formattedDateTime;
    }
}
