package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
         String file1 =args[0];
         String file2 =args[1];
       //   String file1 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";
       //   String file2 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\3.txt";

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
      //  String name;

        //  System.out.println();
        StringBuilder newBuild = new StringBuilder();
     //   int match;
        for (int i = 0; i < a.size(); i++) {
            stroka = a.get(i).split(" ");
            for(int y=0;y<stroka.length;y++){
                if (stroka[y].length()>6)
                    newBuild.append(stroka[y]).append(",");
            }
        }

        newBuild.deleteCharAt(newBuild.lastIndexOf(","));



        FileWriter strOut = new FileWriter(file2);
        //  strOut.write(resultBuild.toString());
        char[] charArr = new char[newBuild.length()];
        charArr=newBuild.toString().toCharArray();
        for(int i=0;i<charArr.length;i++){
            strOut.write(charArr[i]);
        }

        strOut.close();
    }
}

/*Длинные слова
        В метод main первым параметром приходит имя файла1, вторым — файла2.
        Файл1 содержит слова, разделенные пробелом.
        Записать через запятую в Файл2 слова, длина которых строго больше 6.
        В конце файла2 запятой не должно быть.
        Закрыть потоки.

        Пример выходных данных в файл2:
        длинное,короткое,аббревиатура


        Требования:
        1. Программа НЕ должна считывать данные с консоли.
        2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
        3. Поток чтения из файла (FileReader) должен быть закрыт.
        4. Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
        5. Поток записи в файл (FileWriter) должен быть закрыт.*/