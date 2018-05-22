package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String f1 = r.readLine();
        String f2 = r.readLine();
        String f3 = r.readLine();
        r.close();
        FileInputStream str = new FileInputStream(f1);
        int count1,count2;
        if (str.available()%2==0) {
            count1 = (str.available() / 2);
            count2 = (str.available() / 2);
        }
        else {
            count1 = (str.available() / 2) + 1;
            count2 = (str.available() / 2);
        }

       // System.out.println(str.available()+" "+count1+" "+count2);
        byte[] buffer = new byte[count1];
        byte[] buffer2 = new byte[count2];

        str.read(buffer);
        FileOutputStream strO1 = new FileOutputStream(f2);
        strO1.write(buffer,0,buffer.length);

        str.read(buffer2);
        FileOutputStream strO2 = new FileOutputStream(f3);
        strO2.write(buffer2,0,buffer2.length);
        /*  byte[] buffer = new byte[1000];
 while (inputStream.available() > 0) //пока есть еще непрочитанные байты
 {
  // прочитать очередной блок байт в переменную buffer и реальное количество в count
  int count = inputStream.read(buffer);
  outputStream.write(buffer, 0, count);*/
       // System.out.println("ok");
        //System.out.println(str.available()+" "+count1+" "+count2);
       // System.out.println(buffer.length-1+" "+(count1+1)+" "+(count1+buffer2.length));


        str.close();;
        strO1.close();
        strO2.close();
    }

}
/*Разделение файла
c:\Users\mr_ma\Documents\Даша\java\1.txt
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.*/
