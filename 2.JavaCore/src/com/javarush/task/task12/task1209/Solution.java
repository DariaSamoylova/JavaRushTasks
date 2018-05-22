package com.javarush.task.task12.task1209;

/* 
Три метода и минимум
*/

public class Solution {
    public static void main(String[] args) {

    }
    public static int min(int w, int e){
        return w>e?e:w;
    }
    public static long min(long f, long d){
return f>d?d:f;
    }
    public static double min(double c, double b){
return  c>b?b:c;
    }
    //Напишите тут ваши методы
}
/*Три метода и минимум
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.


Требования:
1. Программа не должна выводить текст на экран.
2. Класс Solution должен содержать четыре метода.
3. Класс Solution должен содержать статический метод int min(int, int).
4. Метод int min(int, int) должен возвращать минимальное из двух чисел типа int.
5. Класс Solution должен содержать статический метод long min(long, long).
6. Метод long min(long, long) должен возвращать минимальное из двух чисел типа long.
7. Класс Solution должен содержать статический метод double min(double, double).
8. Метод double min(double, double) должен возвращать минимальное из двух чисел типа double.*/