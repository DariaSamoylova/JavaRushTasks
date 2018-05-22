package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел

код работает верно
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
static {
     map.put(0,"ноль");
    map.put(1,"один");
    map.put(2,"два");
    map.put(3,"три");
    map.put(4,"четыре");
    map.put(5,"пять");
    map.put(6,"шесть");
    map.put(7,"семь");
    map.put(8,"восемь");
    map.put(9,"девять");
    map.put(10,"десять");
    map.put(11,"одиннадцать");
    map.put(12,"двенадцать");

  //  map.put(0,"qwe");
  //  map.put(1,"asd");
}
    public static void main(String[] args) throws IOException {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String file1 = r.readLine();

           r.close();

      //  String file1 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";

        FileReader str = new FileReader(file1);

        StringBuilder strBuild = new StringBuilder();
        ArrayList<String> a = new ArrayList<>();

        int bukva;

        while (str.ready()) {
            bukva = str.read();
            if (bukva == 10) {
                a.add(strBuild.toString());
                strBuild = new StringBuilder();
            } else if (bukva != 13)
                strBuild.append((char) bukva);

        }
        a.add(strBuild.toString());

        str.close();

       //  Pattern p = Pattern.compile("\\p{Punct}[0-9|10|11|12]\\p{Punct}");
      // Pattern p = Pattern.compile("\\p{Punct}[0-12]\\p{Punct}");
         Pattern p;// = Pattern.compile("(\\p{Punct}|\\s)[0](\\p{Punct}|\\s)");

       // System.out.println("345 0. 456");
         Matcher m ;//= p.matcher("345 0. 456");





     /*   p= Pattern.compile("(\\p{Punct}|\\s)"+12+"(\\p{Punct}|\\s)");
        m=p.matcher("  -12. ");
        System.out.println(m.find());
        String g="  -12. ";
        char[] r = g.toCharArray();
        for(char d:r){
            System.out.println((byte)d);
        }

*/







       // System.out.println(m.find());
//   g.set(i,g.get(i).replaceAll("\\p{Punct}", ""));
        // String[] stroka;
        String stroka;
        for (int i = 0; i < a.size(); i++) {
            stroka=a.get(i);
          //  System.out.println(stroka);
            for(int y=0;y<13;y++)
            {
                p= Pattern.compile("(\\p{Punct}|\\s)"+y+"(\\p{Punct}|\\s)");
                m=p.matcher(stroka);
                if (m.find()){
                   // System.out.println(m.start());
                    if (y<10)
                        stroka=stroka.substring(0,m.start()+1)+map.get(y)+stroka.substring(m.start()+2);
                    else
                        stroka=stroka.substring(0,m.start()+1)+map.get(y)+stroka.substring(m.start()+3);
                }

             //   stroka=stroka.replace("(\\p{Punct}|\\s)["+y+"](\\p{Punct}|\\s)",map.get(y));


            }
        System.out.println(stroka);
        }
            //   match=0;
         /*   stroka = a.get(i).split(" ");
            for(int y=0;y<stroka.length;y++){
                for(int j=0;j<words.size();j++){
                    if (stroka[y].equals(words.get(j)))
                        match++;
                }
            }
            if (match==2)
                System.out.println(a.get(i));
        }*/


    }
}
/*Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
Например, 0 — «ноль«, 1 — «один«, 2 — «два»
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.


Требования:
1. Класс Solution должен содержать публичное статическое поле map типа Map, которое должно быть сразу проинициализировано.
2. Программа должна считывать имя файла с консоли (используй BufferedReader).
3. BufferedReader для считывания данных с консоли должен быть закрыт.
4. Программа должна считывать содержимое файла (используй FileReader).
5. Поток чтения из файла (FileReader) должен быть закрыт.
6. Программа должна выводить в консоль все строки из файла, но числа должны быть заменены на слова из словаря map.
7. Класс Solution должен содержать статический блок, в котором добавляются в map тринадцать пар.*/