package com.javarush.task.task19.task1908;

/* 
Выделяем числа
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
      //  String f2 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\3.txt";
        ArrayList<String> g = new ArrayList<>();

        BufferedReader strIn = new BufferedReader(new FileReader(f1));
        String stroka;
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m;
        String result="";
        while(true){
            stroka=strIn.readLine();
            if (stroka==null) break;
            g.add(stroka);
        }

        for(int i = 0;i<g.size();i++){
           String[] arr = g.get(i).split(" ");
           for(int j=0;j<arr.length;j++){
                m= p.matcher(arr[j]);
                if (m.matches()) result=result+arr[j]+" ";
           }
        }
        strIn.close();

        BufferedWriter strOut = new BufferedWriter(new FileWriter(f2));
        strOut.write(result);
        strOut.close();

    }
}
/*    String g=contact.getPhoneNumber();
            Pattern p = Pattern.compile("[0-9]");
            Matcher m = p.matcher(g);

            String h="";
            while (m.find()) {
                h=h+m.group();
            }*/
/*Выделяем числа
        Считать с консоли 2 имени файла.
        Вывести во второй файл все числа, которые есть в первом файле.
        Числа выводить через пробел.
        Закрыть потоки.

        Пример тела файла:
        12 text var2 14 8v 1

        Результат:
        12 14 1


        Требования:
        1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
        2. BufferedReader для считывания данных с консоли должен быть закрыт.
        3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
        4. Поток чтения из файла (BufferedReader) должен быть закрыт.
        5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
        6. Поток записи в файл (BufferedWriter) должен быть закрыт.*/