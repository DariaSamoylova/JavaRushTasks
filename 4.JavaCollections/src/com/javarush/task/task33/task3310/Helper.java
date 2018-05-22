package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by mr_ma on 19.02.2018.
 */
public class Helper {
  public  static  String generateRandomString(){
          SecureRandom random = new SecureRandom();


            return new BigInteger(130, random).toString( 32);


    }

    static void  printMessage(String message){
        System.out.println(message);
    }
}
/*4.1.1. Добавь в него статический метод String generateRandomString(),
 который будет генерировать случайную строку. Воспользуйся для этого классами SecureRandom и BigInteger. Подсказка: гугли запрос "random string java".
 4.1.2. Добавь в класс статический метод printMessage(String message). Он должен выводить переданный текст в консоль. Весь дальнейший вывод в программе должен быть реализован через этот метод!
 */