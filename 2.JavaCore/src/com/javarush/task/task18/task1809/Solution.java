package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String f1 = r.readLine();
            String f2 = r.readLine();
r.close();

        FileInputStream str = new FileInputStream(f1);
            byte[] arr=new byte[str.available()];
        int i=arr.length-1;
            while (str.available()>0){
                arr[i]=(byte)str.read();
                i--;
            }


        FileOutputStream str1 = new FileOutputStream(f2);
            str1.write(arr);

            str.close();
            str1.close();
    }
}
/*Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.*/