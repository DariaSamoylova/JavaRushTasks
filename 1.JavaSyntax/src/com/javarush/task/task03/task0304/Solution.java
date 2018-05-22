package com.javarush.task.task03.task0304;

/* 
Задача на проценты
*/

public class Solution {
    public static double addTenPercent(int i) {
        return (double)i+(double)i*0.1;
        //напишите тут ваш код
    }

    public static void main(String[] args) {

        System.out.println(addTenPercent(9));
    }

}
