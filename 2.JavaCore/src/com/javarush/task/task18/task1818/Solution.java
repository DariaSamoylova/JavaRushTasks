package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String f1 = r.readLine();
        String f2 = r.readLine();
        String f3 = r.readLine();
        r.close();

        FileInputStream strIn1 = new FileInputStream(f2);
        FileInputStream strIn2 = new FileInputStream(f3);
        FileOutputStream strOut = new FileOutputStream(f1);

        byte[] a = new byte[strIn1.available()];
        strIn1.read(a);
        strOut.write(a);

      //  strIn1=new FileInputStream(f3);
       // FileOutputStream strOut = new FileOutputStream(f1);
        byte[] b = new byte[strIn2.available()];
        strIn2.read(b);
       // strOut.write(b,a.length+1,a.length+1+b.length);
        strOut.write(b );


        strIn1.close();
         strIn2.close();
        strOut.close();
    }
}
/*Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.*/