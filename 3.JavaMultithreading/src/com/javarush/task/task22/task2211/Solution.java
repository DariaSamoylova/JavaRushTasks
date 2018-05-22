package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String f1 = args[0];
       String f2 = args[1];
       //   String f1 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";

       //     String f2 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\3.txt";

        Charset koi8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");

        FileInputStream r1 = new FileInputStream(f1);
        byte[] arrByte = new byte[r1.available()];
        while (r1.available()>0){
            r1.read(arrByte);
        }
        r1.close();

        String s = new String(arrByte, windows1251);
        arrByte = s.getBytes(koi8);

        FileOutputStream r2 = new FileOutputStream(f2);
        r2.write(arrByte);
        r2.close();
        /*Charset koi8 = Charset.forName("KOI8-R");
Charset windows1251 = Charset.forName("Windows-1251");

byte[] buffer = new byte[1000];
inputStream.read(buffer);
String s = new String(buffer, koi8);
buffer = s.getBytes(windows1251);
outputStream.write(buffer);*/
    }
}
/*Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.


Требования:
1. Программа НЕ должна считывать данные с клавиатуры.
2. Программа НЕ должна выводить данные на экран.
3. Программа должна записывать данные в файл.
4. Содержимое второго файла должно соответствовать содержимому первого файла за исключением кодировки(UTF-8).*/