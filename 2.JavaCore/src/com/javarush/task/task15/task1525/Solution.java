package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
/*BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                        new InputStreamReader(
                            new FileInputStream(FILE_NAME), Charset.forName("UTF-8")));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // log error
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // log warning
                }
            }
        }*/
    static{
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream( Statics.FILE_NAME)));
            String line;
            while ((line = r.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e){

        }
    }
    public static void main(String[] args) {
        System.out.println(lines);
    }
}

/*Файл в статическом блоке
1. Инициализируй переменную Statics.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Statics.FILE_NAME все строки и добавь их по отдельности в List lines.


Требования:
1. Константа FILE_NAME не должна быть пустой.
2. В статическом блоке все строки из файла с именем FILE_NAME должны быть добавлены по-отдельности в список lines.
3. Поле FILE_NAME НЕ должно быть final.
4. Класс Solution должен содержать список lines.*/