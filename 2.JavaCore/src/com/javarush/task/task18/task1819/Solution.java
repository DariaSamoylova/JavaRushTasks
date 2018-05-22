package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String f1 = r.readLine();
        String f2 = r.readLine();

        r.close();



        FileInputStream strIn1 = new FileInputStream(f1);
        FileInputStream strIn2 = new FileInputStream(f2);
        FileOutputStream strOut = new FileOutputStream(f1);

        byte[] a = new byte[strIn1.available()];
        strIn1.read(a);
      //  strOut.write(a);

        //  strIn1=new FileInputStream(f3);
        // FileOutputStream strOut = new FileOutputStream(f1);
        byte[] b = new byte[strIn2.available()];
        strIn2.read(b);
        // strOut.write(b,a.length+1,a.length+1+b.length);
        strOut.write(b );
        strOut.write(a );

        strIn1.close();
        strIn2.close();
        strOut.close();
    }
}
/*Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения и считай его содержимое.
3. Затем, для первого файла создай поток для записи. Для второго - для чтения.
4. Содержимое первого и второго файла нужно объединить в первом файле.
5. Сначала должно идти содержимое второго файла, затем содержимое первого.
6. Созданные для файлов потоки должны быть закрыты.*/