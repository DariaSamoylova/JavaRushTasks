package com.javarush.task.task40.task4012;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/* 
Полезные методы DateTime API
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isLeap(LocalDate date) {
/*int year = date.getYear();
if (year%400==0) return true;
if (year%100==0) return false;
if (year%4==0) return  true;
return false;*/
return date.isLeapYear();
    }

    public static boolean isBefore(LocalDateTime dateTime) {
LocalDateTime loc = LocalDateTime.now();
return dateTime.isBefore(loc);
    }

    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
     return  chronoUnit.addTo(time,n);
    }

    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {
        boolean q =false;
        q=firstDate.isBefore(secondDate);
        if (q)
            return Period.between(firstDate,secondDate);
        else
            return Period.between(secondDate,firstDate);
    }
}
/*Полезные методы DateTime API
В Java 8 DateTime API реализовано множество классов и методов, которые существенно упрощают работу со временем и датами.

Реализуем несколько простых методов, чтобы познакомиться с ними поближе.

1) Метод isLeap должен принимать дату и возвращать true, если год является високосным, иначе - false.
2) Метод isBefore должен принимать дату и возвращать true, если она предшествует текущей дате, иначе - false.
3) Метод addTime должен возвращать полученное в качестве параметра время, увеличенное на n СhronoUnit.
4) Метод getPeriodBetween должен принимать две даты и возвращать временной промежуток между ними. Помни, что в метод Period.between необходимо передать сначала меньшую, а затем большую дату.


Требования:
1. Метод isLeap должен принимать дату и возвращать true, если год является високосным, иначе - false.
2. Метод isBefore должен принимать дату и возвращать true, если она предшествует текущей дате, иначе - false.
3. Метод addTime должен возвращать полученное в качестве параметра время, увеличенное на n СhronoUnit.
4. Метод getPeriodBetween должен принимать две даты и возвращать временной промежуток между ними.*/