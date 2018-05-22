package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName = r.readLine();
        r.close();
        ArrayList<Integer> set = new ArrayList<>();
        BufferedReader fIn = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
       // FileInputStream fIn = new FileInputStream(fileName);
//while(fIn.available()>0){
        while(true){
            String line = fIn.readLine();
            if (line==null) break;
  //  System.out.println(line);
            int t = Integer.parseInt(line);
            if ((t%2)==0)
                set.add(t);
}
        fIn.close();
        Collections.sort(set);
for(Integer i:set){
    System.out.println(i);
}
    }
}
/*Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
c:\Users\mr_ma\Documents\Даша\java\1.txt
Пример ввода:
5
8
11
3
2
10
--
59
25
22
10
16
11
1
4
Пример вывода:
2
8
10


Требования:
1. Программа должна считывать данные с консоли.
2. Программа должна создавать FileInputStream для введенной с консоли строки.
3. Программа должна выводить данные на экран.
4. Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
5. Программа должна закрывать поток чтения из файла(FileInputStream).*/