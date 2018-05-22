package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {


    public static void main(String[] args) throws IOException {
       BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String f1 = r.readLine();
        String f2 = r.readLine();
        r.close();


      //   String f1 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";
     //    String f2 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\3.txt";


        ArrayList<String> g = new ArrayList<>();

        BufferedReader strIn = new BufferedReader(new FileReader(f1));
        String stroka;

        String result = "";

        while (true) {
            stroka = strIn.readLine();
            if (stroka == null) break;
            g.add(stroka);
        }


        for (int i = 0; i < g.size(); i++) {
          //  System.out.println(g.get(i));
         //   System.out.println(g.get(i).replace(".","!"));
            g.set(i,g.get(i).replace(".","!"));
          /*  char[] arr = g.get(i).toCharArray();
            for (int j = 0; j < arr.length; j++) {
              if (arr[i]=='.')
                  arr[i]='!';
            }
            g.set(i,arr.toString());*/
        }
        strIn.close();

        BufferedWriter strOut = new BufferedWriter(new FileWriter(f2));
        for (int i = 0; i < g.size(); i++) {
            strOut.write(g.get(i));
        }
        strOut.close();
    }
}
/*Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла и заменить все точки «.» на знак «!«.
Результат вывести во второй файл.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла, где заменены все точки "." на знак "!" (Для записи в файл используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.*/