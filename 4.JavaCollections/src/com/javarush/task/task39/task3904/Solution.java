package com.javarush.task.task39.task3904;

import java.util.Arrays;

/* 
Лестница
*/
public class Solution {
    private static int n = 70;
    public static void main(String[] args) {
        System.out.println("Number of possible runups for " + n + " stairs is: " + countPossibleRunups(n));
    }

    public static long countPossibleRunups(int n) {
       if (n==0) return  1;
        if (n==1) return  1;
        if (n==2) return  2;
        if (n==3) return  4;
        if (n<0) return  0;
        long sum=0;
        long a=1,b=2,c=4;
        for(int i=3;i<n;i++){
            sum=a+b+c;
            a=b;
            b=c;
            c=sum;
        }
return sum;
    }
}

/*Лестница
Ребенок бежит по лестнице состоящей из N ступенек, за 1 шаг он может пройти одну, две или три ступеньки.

Реализуй метод countPossibleRunups(int n), который вернет количество способов которыми ребенок может пробежать всю лестницу состоящую из n ступенек.

P.S. Если лестница состоит из 0 ступенек - метод должен возвращать 1. Для n < 0 верни 0.


Требования:
1. Метод countPossibleRunups должен возвращать количество способов прохождения лестницы из n ступенек.
2. Метод countPossibleRunups должен возвращать 1 для n = 0.
3. Метод countPossibleRunups должен возвращать 0 для n < 0.
4. Время выполнения метода countPossibleRunups должно быть линейным.

1 1
2 2
3 4
4 7
5 13
6 24
1 1 1 1 1 1
2 1 1 1 1
1 2 1 1 1
1 1 2 1 1
1 1 1 2 1
1 1 1 1 2
2 2 1 1
2 1 1 2
2 1 2 1
1 2 2 1
1 2 1 2
1 1 2 2
2 2 2
3 1 1 1
1 3 1 1
1 1 3 1
1 1 1 3
3 3
2 3 1
1 2 3
3 1 2
3 2 1
2 1 3
1 3 2
*/