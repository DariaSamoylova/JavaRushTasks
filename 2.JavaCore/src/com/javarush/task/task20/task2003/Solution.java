package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
       BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
         String file1 = r.readLine();

        r.close();

        FileInputStream is = new FileInputStream(file1);
        load(is);
        is.close();
       /*    String file1 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";

        FileReader str = new FileReader(file1);


        Properties properties1 = new Properties();
        properties1.load(str);
        Set<String> keys = properties1.stringPropertyNames();
        for (String key:keys) {
            properties.put(key, properties1.getProperty(key));
        }
*/

      /*  StringBuilder strBuild = new StringBuilder();
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
*/
       // str.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream,null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        properties.putAll((Map)prop);
    }
/*Ну и переходим к первому методу. Как уже говорилось будем в нем юзать метод load(). В нём нам надо считать имя файла откуда будем подгружать конфу.
С помощью BufferedReader получаем имя.
Создаем поток FileInputStream is, из которого будем считывать данные.
вызываем метод load(is);
Закрываем все потоки.*/
    public static void main(String[] args) {

    }
}
/*Знакомство с properties
        В методе fillInPropertiesMap считайте имя файла с консоли и заполни карту properties данными из файла.
        Про .properties почитать тут — http://ru.wikipedia.org/wiki/.properties
        Реализуй логику записи в файл и чтения из файла для карты properties.


        Требования:
        1. Метод fillInPropertiesMap должен считывать данные с консоли.
        2. Метод fillInPropertiesMap должен создавать FileInputStream, передавая считанную строку в качестве параметра.
        3. Метод fillInPropertiesMap должен вызывать метод load передавая только что созданный FileInputStream в качестве параметра.
        4. Метод save должен сохранять карту properties в полученный в качестве параметра объект типа OutputStream.
        5. Метод load должен восстанавливать состояние карты properties из полученного в качестве параметра объекта типа InputStream.*/