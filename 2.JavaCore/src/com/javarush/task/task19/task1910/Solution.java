package com.javarush.task.task19.task1910;

/* 
Пунктуация
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
       //     String f2 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\3.txt";


        ArrayList<String> g = new ArrayList<>();

        BufferedReader strIn = new BufferedReader(new FileReader(f1));
        String stroka;

        String result = "";

     //   Pattern p = Pattern.compile("[.,:;\\-!?\n]+");
      //  Matcher m;

        while (true) {
            stroka = strIn.readLine();
            if (stroka == null) break;
            g.add(stroka);
        }


        for (int i = 0; i < g.size(); i++) {


        //    m= p.matcher(g.get(i));
          //  System.out.println(g.get(i));
          //  System.out.println(m.replaceAll(""));
          //  g.set(i,  m.replaceAll(""));


          //  if (m.matches()) result=result+arr[j]+" ";
       g.set(i,g.get(i).replaceAll("\\p{Punct}", ""));
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
/*Пунктуация
етворяют: запятая (,), точка с запятой (;), двоеточие (:) и точка (.); второму — знаки: восклицательный (!) и вопросительный (?), многоточие (…) и тире (—)».
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.

Результат вывести во второй файл.

http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F

Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла, где удалены все знаки пунктуации, включая символы новой строки (Для записи в файл используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.*/