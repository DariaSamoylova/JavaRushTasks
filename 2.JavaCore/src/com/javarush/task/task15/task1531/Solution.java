package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();
/*if (input>0)//(input<=150&&input>=0)
     {
    System.out.println(factorial(input));
}
else if (input==0){
    System.out.println(1);
}*/
 if (input<0){
    System.out.println(0);
}
else  System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        if (n==0) return "1";
        BigInteger f=BigInteger.valueOf(1);
for(int i=1;i<n;i++){
    f=f.multiply(BigInteger.valueOf(i+1));
  //   System.out.println(i+"---"+f);
}
        return String.valueOf(f);
    }
}
/*Факториал

Biglnteger с = a.add(b); // с = a + b
Biglnteger d = с.multiply(b.add(Biglnteger.value.Of(2))); // d - с * (b + 2)

Написать метод, который вычисляет факториал — произведение всех чисел от 1 до введенного числа включая его.

Пример вычислений: 4! = factorial(4) = 1*2*3*4
Пример вывода: 24

1. Ввести с консоли число меньше либо равно 150.
2. Реализовать функцию factorial.
3. Если введенное число меньше 0, то вывести 0.
0! = 1


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить на экран факториал введенного числа.
3. Метод factorial должен возвращать строковое представление факториала числа переданного ему в качестве параметра.
4. Метод factorial должен принимать один параметр типа int.*/