package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
          String f1=args[0];
       // String f1 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";

        FileInputStream str = new FileInputStream(f1);
        HashMap<Byte,Integer> h = new HashMap<>();

byte t;
int count=0;
        while (str.available()>0){
            t=  (byte)str.read();
            //  System.out.println(t);
            if (h.containsKey(t)){
             //     System.out.println(t+"..."+h.get(t));
                count=h.get(t);
                h.put( t,++count);
            } else
                h.put( t,1);


        }

byte i=0;
while(true){
                if (h.containsKey(i)){
                   System.out.println( (char)i+" "+h.get(i));
               }
    if (i==127) break;
    i++;
}


        str.close();
    }
}
/*
   BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String f = r.readLine();
        r.close();

int t,count=0,max=0;
     //   int max=0,t;
        FileInputStream str = new FileInputStream(f);
       // ArrayList<Integer> a = new ArrayList<>();
        HashMap<Integer,Integer> h = new HashMap<>();

        while (str.available()>0){
          t= str.read();
          //  System.out.println(t);
            if (h.containsKey(t)){
               // System.out.println(t+"..."+h.get(t));
                count=h.get(t);
                h.put( t,++count);
            } else
                h.put( t,1);

            if (max<count) max=count;
        }
        for (Map.Entry s:h.entrySet()){
           // System.out.println(s.getKey()+"--"+s.getValue());
            if ((int)s.getValue()==max){
                System.out.print(s.getKey()+" ");
            }
        }
       // System.out.println(max);
        str.close();

        Встречаемость символов
Программа запускается с одним параметром — именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
‘,’=44, ‘s’=115, ‘t’=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.*/