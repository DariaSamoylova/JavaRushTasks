package com.javarush.task.task30.task3009;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private  static  Set<Integer> getRadix(String number){
        HashSet<Integer> resultSet = new HashSet<>();
        for(int i=0;i<number.length();i++){
            if (!Character.isDigit(number.charAt(i)))
                return resultSet;
        }
try {
    BigInteger bigInteger = new BigInteger(number, 10);
    for (int i = 2; i <= 36; i++) {

        String resString = bigInteger.toString(i);
        boolean isPalindrom = true;
        for (int y = 0; y < resString.length() / 2; y++) {
            if (resString.charAt(y) != resString.charAt(resString.length() - 1 - y)) {
                isPalindrom = false;
                break;
            }

        }
        if (isPalindrom)
            resultSet.add(i);
    }
} catch (NumberFormatException e){

}
         return resultSet;

                /*  BigInteger bigInteger = new BigInteger(num,number.getNumerationSystem().getNumerationSystemIntValue());
String resString = bigInteger.toString(expectedNumerationSystem.getNumerationSystemIntValue());
return new Number(expectedNumerationSystem, resString);*/
    }
}
/*Палиндром?
Объяви и реализуй логику приватного статического метода Set<Integer> getRadix(String number), в котором нужно определить,
 в каких системах счисления (от 2 до 36 включительно) представление числа number (передается в десятичной системе счисления) является палиндромом и добавить индекс таких систем в результат.
Если переданное число некорректно - возвращай пустой HashSet.
В системах счисления с основанием большим 10 в качестве цифр используются латинские буквы. К примеру, числу 35 в десятичной системе соответствует число "Z" в системе с основанием 36.

Метод main не принимает участие в тестировании.

P.S.: В методе getRadix перехватывай NumberFormatException. Стек-трейс выводить не нужно.


Требования:
1. Необходимо объявить приватный статический метод Set getRadix(String number).
2. Метод getRadix в случае некорректных входных данных должен возвращать пустой HashSet.
3. Методе getRadix не должен бросать NumberFormatException.
4. Метод getRadix не должен ничего выводить в консоль.
5. Метод getRadix должен возвращать множество согласно условию задачи.*/