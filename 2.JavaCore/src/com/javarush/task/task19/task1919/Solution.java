package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {

        //   BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        //   String f = r.readLine();
        //  r.close();

        //  String f = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";
       //    args = new String[1];
        String f =args[0] ;
       // String f = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";

        StringBuilder strBuild = new StringBuilder();
        ArrayList<String> a = new ArrayList<>();
        FileReader str = new FileReader(f);
        int bukva;

        while (str.ready()) {
            bukva = str.read();
            if (bukva == 10) {
                a.add(strBuild.toString());
                strBuild = new StringBuilder();
            } else
                strBuild.append((char) bukva);

        }
        a.add(strBuild.toString());

        str.close();

      /*  for(String g:a){
            System.out.println(g);
        }*/

        HashMap<String,Double> h = new HashMap<>();
        String[] stroka;
        for(int i=0;i<a.size();i++){
           stroka = a.get(i).split(" ");
           if (h.get(stroka[0])!=null){
               h.put(stroka[0],h.get(stroka[0])+Double.parseDouble(stroka[1]));
           }
           else
               h.put(stroka[0],Double.parseDouble(stroka[1]));
        }

        stroka=new String[h.size()];
        int y=0;
     //   System.out.println();
        double max = 0;
        for(Map.Entry<String,Double> q:h.entrySet()){
           // System.out.println(q.getKey()+"---"+q.getValue());
            stroka[y]=q.getKey();
            y++;
            if (q.getValue()>max) max = q.getValue();
        }


     //   stroka=(String[])h.keySet().toArray();

       /* System.out.println();
        for(int i=0;i<stroka.length;i++){
            System.out.println(stroka[i]);
        }*/
        Arrays.sort(stroka);

      //  System.out.println();
        for(int i=0;i<stroka.length;i++){
            if (h.get(stroka[i])==max)
            System.out.println(stroka[i]+" "+h.get(stroka[i]));
        }
    }
}
/*Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] — String, [значение] — double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль каждое имя и сумму всех его значений, все данные должны быть отсортированы в возрастающем порядке по имени.*/