package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
      //  System.out.print(Math.exp(Math.log(9)/3));
     //   System.out.print(Math.log(27)/Math.log(3));
    }

    public static boolean isPowerOfThree(int n) {

        if ((Math.log(n)/Math.log(3))%1==0) {
            return true;
        }
        return false;
    }
}
/*isPowerOfThree
        Исправь ошибку в методе isPowerOfThree(int n), он должен возвращать true, если n является целочисленной степенью числа 3. Иначе - false.
log a (b) = log c (b) / log c (a)
3^n=27

27
        Требования:
        1. Метод isPowerOfThree должен возвращать true, если n является целочисленной степенью числа 3.
        2. Метод isPowerOfThree должен возвращать false, если n не является целочисленной степенью числа 3.
        3. Метод isPowerOfThree должен быть публичным.
        4. Метод isPowerOfThree должен быть статическим.*/