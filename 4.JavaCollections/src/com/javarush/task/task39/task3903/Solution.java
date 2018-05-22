package com.javarush.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Неравноценный обмен
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Please type in a number: ");

        long number = Long.parseLong(reader.readLine());
      //  long number = 37;
        System.out.println("Please type in first index: ");
        int i = Integer.parseInt(reader.readLine());
      //  int i = 1;
        System.out.println("Please type in second index: ");
        int j = Integer.parseInt(reader.readLine());
      //  int j = 2;

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {
  /*      StringBuilder stringBuilder = new StringBuilder( Long.toBinaryString(number));
        stringBuilder= stringBuilder.reverse();
        char[]  r = stringBuilder.toString().toCharArray();
        char a= r[i];
        r[i]=r[j];
        r[j]=a;
        String g =String.copyValueOf(r);
        StringBuilder stringBuilderRR = new StringBuilder( g).reverse();

       long res = Long.parseLong(stringBuilderRR.toString(),2);

        return res;*/
        long a = number >> i & 1;
        long b = number >> j & 1;

        if (a != b)
            number = number & ~((1 << i) | (1 << j)) | (a << j) | (b << i);

        return number;
    }
}
/*Продолжая разработку алгоритма, нам очень бы пригодился метод который бы менял указанные биты
в двоичном представлении числа типа long.
37 bin 100101
2
1
100011 - 1 2 32- 35
Реализуй метод long swapBits(long number, int i, int j), который будет в двоичном представлении числа number менять местами биты с индексами i и j и возвращать результат.

Наименее значимый бит имеет индекс 0.


Требования:
1. Метод swapBits должен быть реализован в соответствии с условием задачи.
2. Метод swapBits должен быть публичным.
3. Метод swapBits должен быть статическим.
4. Метод swapBits должен возвращать число типа long.*/