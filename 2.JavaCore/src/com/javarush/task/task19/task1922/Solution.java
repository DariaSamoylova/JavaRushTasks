package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
      /*  words.add("qwe");
        words.add("asd");
        words.add("zxc");*/
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

        String[] stroka;
        String name;

        //  System.out.println();

int match;
        for (int i = 0; i < a.size(); i++) {
            match=0;
            stroka = a.get(i).split(" ");
            for(int y=0;y<stroka.length;y++){
                for(int j=0;j<words.size();j++){
                    if (stroka[y].equals(words.get(j)))
                        match++;
                }
            }
            if (match==2)
                System.out.println(a.get(i));
        }
    }
}
/*Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.

Пример:
words содержит слова А, Б, В

Строки:
В Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова — подходит, выводим


Требования:
1. Класс Solution должен содержать публичное статическое поле words типа List, которое должно быть сразу проинициализировано.
2. Класс Solution должен содержать статический блок, в котором добавляются три слова в список words.
3. Программа должна считывать имя файла с консоли (используй BufferedReader).
4. BufferedReader для считывания данных с консоли должен быть закрыт.
5. Программа должна считывать содержимое файла (используй FileReader).
6. Поток чтения из файла (FileReader) должен быть закрыт.
7. Программа должна выводить в консоль все строки из файла, которые содержат всего 2 слова из списка words.*/