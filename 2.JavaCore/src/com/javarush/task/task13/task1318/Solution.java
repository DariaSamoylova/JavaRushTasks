package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

            String g = r.readLine();




        InputStream i = new FileInputStream(g);
while (i.available()>0) {
    System.out.write(i.read());
}

        System.out.println();
        i.close();
r.close();
    }
}
/*public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        FileInputStream in = new FileInputStream(fileName);



        while(in.available()>0) {

            System.out.write(in.read());

        }

        System.out.println();



        in.close();

        reader.close();

    }

}*/
/*Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.


Требования:
1. Программа должна считывать c консоли имя файла.
2. Программа должна выводить на экран содержимое файла.
3. Поток чтения из файла (FileInputStream) должен быть закрыт.
4. BufferedReader также должен быть закрыт.*/