package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String f = r.readLine();
        r.close();

        int t,count=1,max=Integer.MAX_VALUE;
        //   int max=0,t;
        FileInputStream str = new FileInputStream(f);
        // ArrayList<Integer> a = new ArrayList<>();
        HashMap<Integer,Integer> h = new HashMap<>();

        while (str.available()>0){
            t= str.read();
          //    System.out.println(t);
            if (h.containsKey(t)){
            //     System.out.println(t+"..."+h.get(t));
                count=h.get(t);
                h.put( t,++count);
            } else
                h.put( t,1);

          //  if (max>count) max=count;
        }
        for (Map.Entry s:h.entrySet()){
          //  System.out.println(s.getKey()+"--"+s.getValue());
            if ((int)s.getValue()<max){
                max=(int)s.getValue();
            }
        }
     //   System.out.println(max+" max");

        for (Map.Entry s:h.entrySet()){
         //   System.out.println(s.getKey()+"--"+s.getValue());
            if ((int)s.getValue()==max){
                System.out.print(s.getKey()+" ");
            }
        }
        // System.out.println(max);
        str.close();
    }
}
/*Самые редкие байты
Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с минимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.*/