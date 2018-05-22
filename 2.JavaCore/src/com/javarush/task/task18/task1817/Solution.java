package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
   FileInputStream str = new FileInputStream(args[0]);
         Pattern p = Pattern.compile("^\\s$");
        Matcher m;

      //  FileInputStream str = new FileInputStream("c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt");
int total=str.available();
        int count=0;
        while (str.available()>0){

           String simvol = String.valueOf(((char)str.read()));
           m=p.matcher(simvol);
          if (m.matches()) count++;

        }
        str.close();
        System.out.printf("%.2f", (double)count/(double)total*100.0);

    }
}
/*Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
4. Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. Посчитай отношение пробелов ко всем символам в файле и выведи в консоль это число.
4. Выведенное значение необходимо округлить до 2 знаков после запятой.
5. Поток чтения из файла должен быть закрыт.*/