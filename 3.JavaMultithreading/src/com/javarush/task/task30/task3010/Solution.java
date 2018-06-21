package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Solution {
    public static void main(String[] args) {
        try {
            for (int i = 2; i < 37; i++) {
                if (isNumber(args[0], i)) {
                    System.out.println(i);
                    break;
                } else {
                    if (i == 36) System.out.println("incorrect");
                }
            }
        } catch (Exception e) {
        }
    }

    public static boolean isNumber(String arg, int radix) {
        boolean result = false;
        try {
            new BigDecimal(new BigInteger(arg, radix));
            result = true;
        } catch (Exception e) {
        }
        return result;
    }
}
/*норм работает не проходит валидацию*/
/*
public class Solution {

    public static void main(String[] args) {
        //напишите тут ваш код
    try {
       String stroka = args[0];
      //  String stroka ="1z2AS08";
      //  if (stroka.length()>255)
        //    return;

        Pattern p = Pattern.compile("[0-9A-Za-z]++");
        Matcher m = p.matcher(stroka);
        if (!m.matches()) {
            System.out.println("incorrect");
            return;
        }
        stroka = stroka.toUpperCase();
        byte maxbyte = 0;
        for (int i = 0; i < stroka.length(); i++) {
            if ((byte) stroka.charAt(i) > maxbyte)
                maxbyte = (byte) stroka.charAt(i);
        }

        int resultSystem;
        if (maxbyte < 58) {
            resultSystem = maxbyte - 48;
            if (resultSystem < 2)
                System.out.println(2);
            else
                System.out.println(resultSystem);
        } else {
            System.out.println(maxbyte - 54);
        }
    } catch (Exception e){

    }
//48 57-65 90     ---65  11
    }
}*/
/*Минимальное допустимое основание системы счисления
В метод main первым аргументом приходит строка, которая содержит последовательность символов (Все символы в строке имеют коды в таблице ASCII от 32 до 127 включительно). Длина строки не превышает
 255 символов. Нужно реализовать программу, которая по входящей строке определит, является ли содержимое строки записью числа в системе счисления с основанием не больше 36 включительно.
 Если является - нужно вывести минимальное основание системы счисления, в которой это число может существовать. Если не является - необходимо вывести "incorrect".
В системах счисления с основанием большим 10 в качестве цифр используются латинские буквы. К примеру, числу 35 в десятичной системе соответствует число "Z" в системе с основанием 36.
Так как рассматриваем позиционные системы счисления - минимальное основание, которое должна выводить программа, это 2.
Если возникают любые исключения - перехватывай их и не выводи стек-трейс.
import java.util.regex.*; Pattern p = Pattern.compile(“[a-z]+”);
Далее вы должны создать matcher для текста, отправив сообщение на схеме:
Matcher m = p.matcher(“code 2 learn java tutorial”);
Пример1:
Вход:
00
Ожидаемый вывод:
2

Пример2:
Вход:
12AS08z
Ожидаемый вывод:
36

Пример3:
Вход:
12AS08Z/
Ожидаемый вывод:
incorrect

*/