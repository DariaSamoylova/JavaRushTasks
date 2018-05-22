package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String f;
        ArrayList<String> arr = new ArrayList<>();
        while (true){
            f=r.readLine();
            if (f.equals("end")) break;
             arr.add(f);

        }

        r.close();

//c:\Users\mr_ma\Documents\Даша\java\1\1.txt.part1
        String newFile = arr.get(0).substring(0, arr.get(0).lastIndexOf("."));
        FileOutputStream outStr = new FileOutputStream(newFile);
        FileInputStream inStr;
        byte[] buff;
        for(int i=1;i<=arr.size();i++){
            inStr=new FileInputStream(newFile+".part"+i);
            buff=new byte[inStr.available()];
            inStr.read(buff);
            outStr.write(buff);
            inStr.close();
        }
        outStr.close();
    }
}
/*Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, …, Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом «end«.
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, …, в конце — последнюю.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.*/