package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
       BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
         String file1 = r.readLine();

     r.close();

      //    String file1 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";


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

      //  String[] stroka;
        //  String name;

        //  System.out.println();
       // StringBuilder newBuild = new StringBuilder();
        //   int match;
        for (int i = 0; i < a.size(); i++) {
            strBuild=new StringBuilder(a.get(i));
            System.out.println(strBuild.reverse());
        }
    }
}
/*
Перевертыши
        1 Считать с консоли имя файла. Считать содержимое файла.
        2 Для каждой строки в файле:
        2.1 переставить все символы в обратном порядке.
        2.2 вывести на экран.
        3 Закрыть потоки.

        Пример тела входного файла:
        я - программист.
        Амиго

        Пример результата:
        .тсиммаргорп - я
        огимА


        Требования:
        1. Программа должна считывать имя файла с консоли (используй BufferedReader).
        2. BufferedReader для считывания данных с консоли должен быть закрыт.
        3. Программа должна считывать содержимое файла (используй FileReader).
        4. Поток чтения из файла (FileReader) должен быть закрыт.
        5. Программа должна выводить в консоль все символы из файла в обратном порядке.*/