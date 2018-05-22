package com.javarush.task.task39.task3902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Биты были биты
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please type in a number: ");

       // long l = Long.parseLong(reader.readLine());
        long l=37;
        String result = isWeightEven(l) ? "even" : "odd";
        System.out.println("Number of ones in a given number is " + result);

    }

    public static boolean isWeightEven(long number) {
     /*  String s =  Long.toBinaryString(number);
       System.out.println(s);
       int a=0;
       for(int i=0;i<s.length();i++){
           if (s.charAt(i)=='1')
               a++;
       }
        return a%2==0?true:false;*/
             int count = 0;
        System.out.println(number+" bin "+Long.toBinaryString(number));
        while (number != 0) {
            count++;
            System.out.println("count = "+count+" --- "+number+" bin "+Long.toBinaryString(number)+" number-1="+(number-1)+" bim "+Long.toBinaryString(number-1));
            number = number & (number - 1);
            System.out.println(number+" bin "+Long.toBinaryString(number) );
        }
        if (count % 2 == 0) return true;
        return false;
    }
}
/*Биты были биты
В процессе разработки сложного алгоритма кодирования возникла задача определить четное ли количество единиц в двоичной записи числа.
100101
1 4 32 37
100100
 4 32 36
Реализуй метод boolean isWeightEven(long number), который будет возвращать true или false в зависимости от того, является ли количество единиц в двоичном представлении числа number четным или нечетным.

P.S. Постарайся использовать только побитовые операции, а также минимизировать время выполнения программы.


Требования:
1. Метод isWeightEven должен возвращать true, если количество единиц в двоичном представлении анализируемого числа четное.
2. Метод isWeightEven должен возвращать false, если количество единиц в двоичном представлении анализируемого числа нечетное.
3. Время выполнения метода isWeightEven должно быть максимально близко к оптимальному.
4. Метод isWeightEven должен быть публичным и статическим.*/