package com.javarush.task.task40.task4008;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Locale;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        //напишите тут ваш код



       // SimpleDateFormat format = null;
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("d.M.yyyy");
        DateTimeFormatter formatterTime =DateTimeFormatter.ofPattern("H:m:s");
      //  DateTimeFormatter formatterDateTime= DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss");
        LocalTime localTime  = null;
        LocalDate localDate  = null;

        if (date.contains(":")&&date.length()>8) {

              localTime = LocalTime.parse(date.substring(date.indexOf(" ")+1),formatterTime);
              localDate = LocalDate.parse(date.substring(0,date.indexOf(" ")),formatterDate);

        }

       else if (date.contains(":")) {

              localTime = LocalTime.parse(date,formatterTime);

        }


        else   {

              localDate = LocalDate.parse(date,formatterDate);


        }





        if (localDate!=null) {
            System.out.println("День: " + localDate.getDayOfMonth());
         //   System.out.println("День недели: " + ((localDate.getDayOfWeek().getValue() - 1) == 0 ? 7 : localDate.getDayOfWeek().getValue() - 1));
            System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
            System.out.println("День месяца: " + localDate.getDayOfMonth());
            System.out.println("День года: " + localDate.getDayOfYear());
            System.out.println("Неделя месяца: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
            System.out.println("Неделя года: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
            System.out.println("Месяц: " + (localDate.getMonth().getValue() ));
            System.out.println("Год: " + localDate.getYear());
        }

        if (localTime!=null) {
            System.out.println("AM или PM: " + (localTime.get(ChronoField.AMPM_OF_DAY) == 0 ? "AM" : "PM"));
            System.out.println("Часы: " + localTime.get(ChronoField.HOUR_OF_AMPM));
            System.out.println("Часы дня: " + localTime.getHour());
            System.out.println("Минуты: " + localTime.getMinute());
            System.out.println("Секунды: " + localTime.getSecond());
        }
    }
}
