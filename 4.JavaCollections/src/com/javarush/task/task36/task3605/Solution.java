package com.javarush.task.task36.task3605;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       //   String fileName="c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";//args[0];
        String fileName = args[0];


        TreeSet<Character> characters = new TreeSet<>();
        FileReader r = new FileReader(fileName);
        Pattern p = Pattern.compile("\\w");

        // StringBuilder b = new StringBuilder();
        while (true) {
            int t = r.read();
            if (t < 0) break;
            char c = (char) t;
            Matcher m = p.matcher(String.valueOf(c));
            //b.append(c);
            if (m.matches())
                characters.add(Character.toLowerCase(c));
            //  System.out.print(c);
        }
        r.close();
        //    System.out.println();
         //  System.out.println(characters);
      /*  if (characters.size() <= 5) {
            for (int i = 0; i <= characters.size(); i++) {
                char ch = characters.first();
                System.out.print(ch);
                characters.remove(ch);
            }
            System.out.print(characters.first());
        } else

            for (int i = 0; i < 5; i++) {
                char ch = characters.first();
                System.out.print(ch);
                characters.remove(ch);
            }
*/


        Iterator<Character> iterator = characters.iterator();
        int n = characters.size() < 5 ? characters.size() : 5;

        for (int i = 0; i < n; i++) {
            System.out.print((iterator.next()));
        }



        //     System.out.println(characters);

       /*  states.add("Германия");
        states.add("Франция");
        states.add("Италия");
        states.add("Великобритания");
      //  System.out.println(states.first()); // получим первый - самый меньший элемент
      //  System.out.println(states.last()); // получим последний - самый больший элемент
        // получим поднабор от одного элемента до другого
        SortedSet<String> set = states.subSet("Великобритания", "Франция");
       System.out.println(set);
        // элемент из набора, который больше текущего
        String greater = states.higher("Германия");
        System.out.println(greater);
        // элемент из набора, который больше текущего
       String lower = states.lower("Германия");
        System.out.println(lower);
        // возвращаем набор в обратном порядке
        NavigableSet<String> navSet = states.descendingSet();
        // возвращаем набор в котором все элементы меньше текущего
        SortedSet<String> setLower=states.headSet("Германия");
        System.out.println(setLower);
        // возвращаем набор в котором все элементы больше текущего
        SortedSet<String> setGreater=states.tailSet("Германия");*/
    }
}

/*Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортируй буквы по алфавиту и выведи на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то выведи их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрой потоки.

Пример 1 данных входного файла:
zBk yaz b-kN

Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB

Пример 2 вывода:
abc

Подсказка: использовать TreeSet


Требования:
1. Программа должна использовать класс TreeSet.
2. У объекта типа TreeSet вызови метод add для добавления элементов.
3. Программа должна выводить результат на экран.
4. Вывод программы должен соответствовать условию задачи.*/