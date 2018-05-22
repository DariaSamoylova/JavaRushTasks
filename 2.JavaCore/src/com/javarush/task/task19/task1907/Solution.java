package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String f1 = r.readLine();

       r.close();


      //  String f1 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";


        FileReader fR = new FileReader(f1);
        String g="";
        while (fR.ready()){
          //  char a = (char)fR.read();
            g=g+(char)fR.read();
        }
        fR.close();
        int count=0;
         for(int i=0;i<g.length()-5;i++){
           if (  g.substring(i,i+5).equals("world"))
               count++;
         }

         System.out.println(count);
    }
}
/*Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов «world«, которые встречаются в файле.
Закрыть потоки.


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.*/