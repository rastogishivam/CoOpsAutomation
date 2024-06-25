package com.org.coops.utilities;

import com.org.coops.constant.Tdata;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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

    public static String getPreviousYear(){
        LocalDateTime now = LocalDateTime.now().minusYears(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String formattedDateTime = now.format(formatter);
        return formattedDateTime;
    }

    public static String convertDateToYYYY_MM_DD(String inputDate){
        String outputDate = null;
        if(inputDate.equalsIgnoreCase("today")){
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDateTime = now.format(formatter);
            outputDate = formattedDateTime;
        }else{
            if(inputDate.matches(Tdata.CSR.REGEX)){
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH);
                LocalDate date = LocalDate.parse(inputDate, inputFormatter);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                outputDate = date.format(outputFormatter);
            }
        }
        return outputDate;
    }

    public static String getNextYearDateOfGivenDate(String inputDate){
        String date = convertDateToYYYY_MM_DD(inputDate);
        LocalDate localDate = LocalDate.parse(date);
        LocalDate nextYearDate = localDate.plusYears(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return nextYearDate.format(formatter);
    }
}
