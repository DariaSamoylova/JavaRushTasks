package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashSet<String> h = new HashSet<>();
        h.add("арбуз");
        h.add("банан");
        h.add("вишня");
        h.add("груша");
        h.add("дыня");
        h.add("ежевика");
        h.add("жень-шень");
        h.add("земляника");
        h.add("ирис");
        h.add("картофель");

        for(String g:h){
            System.out.println(g);
        }
    }
}
/*дыня
ежевика
банан
арбуз
груша
картофель
земляника
ирис
вишня
жень-шеньHashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.


Требования:
1. Объяви переменную коллекции HashSet с типом элементов String и сразу проинициализируй ee.
2. Программа не должна считывать строки с клавиатуры.
3. Программа должна добавлять в коллекцию 10 строк, согласно условию.
4. Программа должна выводить 10 строк из коллекции на экран, каждую с новой строки.*/