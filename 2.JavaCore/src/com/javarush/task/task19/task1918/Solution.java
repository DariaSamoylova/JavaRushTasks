package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
         BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
           String f = r.readLine();
           r.close();

      //  String f = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";
     //   args = new String[1];
     //  args[0] = "tag";
        String tag = args[0];
        StringBuilder sBuild = new StringBuilder();
        FileReader str = new FileReader(f);

        while (str.ready()) {
            sBuild.append((char) str.read());

        }
        str.close();
        String g = sBuild.toString();
       // g = g.replaceAll("\n","");
      //  g = g.replaceAll("\r","");


        String h_start = "";
        String h_end = "";


        int start = -1, end=-1, flag = 0;


      //  System.out.println(g);


        for (int i = 0; i < g.length() - tag.length() - 1; i++) {
            h_start = g.substring(i, i + 1 + tag.length());
            h_end = g.substring(i, i + 2 + tag.length());

           //  System.out.println("i="+i+", substr="+h_start);
            if (h_start.equals("<" + tag)) {
                flag++;
                if (flag == 1) {
                    start = i;
                } else {
                 //   flag++;
                }

              //   System.out.println("i="+i+", substr="+h_start+", start="+start+", flag = "+flag);
            }
            if (h_end.equals("</" + tag)) {
                flag--;
                if (flag == 0) {
                    end = i;

                    System.out.println(g.substring(start, end + tag.length() + 3));
                  //  start = -1;
                } else {
                  //  flag--;
                }

           //     System.out.println("i="+i+", substr="+h_end+", end="+end+", flag = "+flag);
            }
        }


    }
}
/*Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang=»en» lang=»en»><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, «span«.
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, n, r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

<span xml:lang="en" lang="en"><b>
<span>
<span>Turanga Leela</span></span>
<span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span><span>girl</span>

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.*/