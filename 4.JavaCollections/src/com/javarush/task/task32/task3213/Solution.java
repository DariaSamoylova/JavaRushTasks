package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       StringReader reader = new StringReader("Khoor Dpljr");
       // StringReader reader = new StringReader("K");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {


       StringBuilder sb = new StringBuilder();

try {
    while (true) {
        int newByte = reader.read();
if (newByte==-1) break;
        int byteToAdd;
      /*  if (newByte >= 65 && newByte <= 90) {
            byteToAdd = newByte + key;
            if (byteToAdd < 65) {
                byteToAdd = 23 + byteToAdd;
            } else if (byteToAdd > 90) {
                byteToAdd = byteToAdd - 23;
            }
            sb.append((char) byteToAdd);
        } else if (newByte >= 97 && newByte <= 122) {
            byteToAdd = newByte + key;
            if (byteToAdd < 97) {
                byteToAdd = 23 + byteToAdd;
            } else if (byteToAdd > 122) {
                byteToAdd = byteToAdd - 23;
            }
            sb.append((char) byteToAdd);
        } else {
            sb.append((char) newByte);
        }*/
        sb.append((char) (newByte+key));

    }
    reader.close();
    return sb.toString();
}
        catch (Exception e){
        return sb.toString();
    }
    }

}

/*Шифр Цезаря
Привет Амиго. Ты знаешь, за нами следят, просматривают нашу переписку. Поэтому нужно шифровать трафик.
Для тебя не составит труда реализовать шифр Цезаря, напомню что это просто сдвиг вправо по алфавиту на key букв.
В методе main есть хороший пример.

Реализуй логику метода String decode(StringReader reader, int key).
Метод получает данные в закодированном виде.
Он должен вернуть дешифрованную строку, что хранится в StringReader - е.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.


Требования:
1. Класс Solution должен содержать метод String decode(StringReader reader, int key).
2. Метод decode(StringReader reader, int key) должен вернуть дешифрованную строку что хранится в StringReader - е.
3. Возвращаемый объект ни при каких условиях не должен быть null.*/