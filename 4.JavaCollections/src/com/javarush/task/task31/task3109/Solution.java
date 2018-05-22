package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args)   {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("c:/Users/mr_ma/Documents/Даша/jv/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("c:/Users/mr_ma/Documents/Даша/jv/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

     //   properties = solution.getProperties("c:/Users/mr_ma/Documents/Даша/jv/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
     //   properties.list(System.out);
    }

    public Properties getProperties(String fileName)   {
        Properties prop = new Properties();
        try {
            if (fileName.endsWith(".xml"))
                prop.loadFromXML(new FileInputStream( fileName ));
            else
            prop.load(new FileReader(fileName ));
            return prop;
        } catch (IOException e) {
            e.printStackTrace();

        }
        return prop;
    }
}
/*Читаем конфиги
Реализовать метод getProperties, который должен считывать свойства из переданного файла fileName.
fileName может иметь любое расширение - как xml, так и любое другое, или вообще не иметь.
Нужно обеспечить корректное чтение свойств.
При возникновении ошибок должен возвращаться пустой объект.
Метод main не участвует в тестировании.

Подсказка: возможно тебе понадобится File.separator.


Требования:
1. Класс Solution должен содержать метод Properties getProperties(String fileName).
2. Метод getProperties должен корректно считывать свойства из xml-файла.
3. Метод getProperties должен корректно считывать свойства из любого другого файла с любым расширением.
4. Метод getProperties должен возвращать пустой объект, если во время чтения свойств возникла ошибка.*/