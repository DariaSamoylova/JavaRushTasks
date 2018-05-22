package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
       BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String file1 = r.readLine();
        String file2 = r.readLine();
        r.close();
//
        //    String file1 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";
        // String file2 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\3.txt";


        ArrayList<Byte> arrB1 = new ArrayList<>();
        FileReader r1 = new FileReader(file1);
        while (r1.ready()){
            arrB1.add((byte)r1.read());
        }
         r1.close();

        ArrayList<Byte> arrB2 = new ArrayList<>();
        FileReader r2 = new FileReader(file2);
        while (r2.ready()){
            arrB2.add((byte)r2.read());
        }
        r2.close();

        ArrayList<String> data1 = new ArrayList<>();
        String builder="";
        for(int i=0;i<arrB1.size();i++){
            if (arrB1.get(i)!=10&&arrB1.get(i)!=13)
                builder=builder+(char)((byte)arrB1.get(i));
          if (arrB1.get(i)==10||i==arrB1.size()-1) {
              data1.add(builder);
              builder="";
          }
       }


        ArrayList<String> data2 = new ArrayList<>();
        String builder2="";
        for(int i=0;i<arrB2.size();i++){
            if (arrB2.get(i)!=10&&arrB2.get(i)!=13)
                builder2=builder2+(char)((byte)arrB2.get(i));
            if (arrB2.get(i)==10||i==arrB2.size()-1) {
                data2.add(builder2);
                builder2="";
            }
        }
       for(String g:data1){
            System.out.println(g);
        }
        System.out.println("---");
        for(String g:data2){
            System.out.println(g);
        }
        System.out.println("---");


       int j=0;
        int flag;//=0;same

        if (data2.get(0).equals(data1.get(0))) {
           // lines.add(new LineItem(Type.SAME,data2.get(0)));
            flag=0;
        } else flag=1;


        for(int i=0;i<data2.size();){
          //  System.out.println("i="+i+"j="+j);
            if (flag==0&&data2.get(i).equals(data1.get(j))) {
                lines.add(new LineItem(Type.SAME,data2.get(i)));
                flag=1;
                ++i;
                ++j;
             //   System.out.println("SAME:i="+i+"j="+j);
            }


           else {
                if ((j+1)<data1.size()&&data2.get(i).equals(data1.get(j+1))) {
                 //   if(i==6&&j==8) {
                    //    lines.add(new LineItem(Type.ADDED, data1.get(j)));
                    //    ++i;
                 //   }
                 //   else {
                        lines.add(new LineItem(Type.REMOVED, data1.get(j)));
                        ++j;
                 //   }
                    flag=0;
                System.out.println("REMOVED:i="+i+"j="+j);
                }
                else  {
                //    if(i==7&&j==10)  lines.add(new LineItem(Type.REMOVED,data2.get(i)));
                    lines.add(new LineItem(Type.ADDED,data2.get(i)));
                    ++i;
                    flag=0;
                  System.out.println("ADDED:i="+i+"j="+j);
                }
            }


        }



        for(LineItem g:lines){
           System.out.println(g.line+":::"+g.type);
        }

     /*   lines.add(new LineItem(Type.SAME,"строка1"));
        lines.add(new LineItem(Type.REMOVED,"строка2"));
        lines.add(new LineItem(Type.SAME,"строка3"));
        lines.add(new LineItem(Type.REMOVED,"строка4"));
        lines.add(new LineItem(Type.SAME,"строка5"));
        lines.add(new LineItem(Type.ADDED,"строка0"));
        lines.add(new LineItem(Type.SAME,"строка1"));
        lines.add(new LineItem(Type.REMOVED,"строка2"));
        lines.add(new LineItem(Type.SAME,"строка3"));
        lines.add(new LineItem(Type.ADDED,"строка5"));
        lines.add(new LineItem(Type.SAME,"строка4"));
        lines.add(new LineItem(Type.REMOVED,"строка5"));*/


    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
/*Отслеживаем изменения
Считать с консоли 2 имени файла — file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
В оригинальном и редактируемом файлах пустых строк нет.

Пример:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1



строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка5            ADDED строка5
строка4         строка4            SAME строка4
строка5                            REMOVED строка5

123 123   0  0
234       1  0
345 345    2  1
456           3 1
567 567      4 2
    678     4   3
789  789      5    4
Требования:
1. Класс Solution должен содержать класс LineItem.
2. Класс Solution должен содержать enum Type.
3. Класс Solution должен содержать публичное статическое поле lines типа List, которое сразу проинициализировано.
4. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
5. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6. Программа должна считывать содержимое первого и второго файла (используй FileReader).
7. Потоки чтения из файлов (FileReader) должны быть закрыты.
8. Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана одна из операций ADDED, REMOVED, SAME.*/