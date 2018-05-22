package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream str = new FileInputStream(args[0]);
        Pattern p = Pattern.compile("^[a-zA-Z]$");
        Matcher m;

      //  FileInputStream str = new FileInputStream("c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt");

        int count=0;
        while (str.available()>0){

           String simvol = String.valueOf(((char)str.read()));
           m=p.matcher(simvol);
          if (m.matches()) count++;

        }
        str.close();
        System.out.println(count);
    }
}
/*Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.
String str = new String(bytes, StandardCharsets.UTF_8);
^[a-zA-Z0-9]+$
q
w
й
ц
123
Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.*/