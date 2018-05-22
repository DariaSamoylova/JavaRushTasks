package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mr_ma on 19.02.2018.
 */
public class Solution {
    public  static void main(String[] args){
        System.out.println("-----------HashMapStorageStrategy----------");
        testStrategy(new HashMapStorageStrategy(),10000);

System.out.println("-----------OurHashMapStorageStrategy----------");
        testStrategy(new OurHashMapStorageStrategy(),10000);

        System.out.println("----------OurHashBiMapStorageStrategy-----------");
        testStrategy(new OurHashBiMapStorageStrategy(),10000);
        System.out.println("----------HashBiMapStorageStrategy-----------");
        testStrategy(new HashBiMapStorageStrategy(),10000);
        System.out.println("----------DualHashBidiMapStorageStrategy-----------");
        testStrategy(new DualHashBidiMapStorageStrategy(),10000);
    }



    static  Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> resultSet = new HashSet<>();
        for(String g:strings){
            resultSet.add(shortener.getId(g));
        }

        return resultSet;
    }

    static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> resultSet = new HashSet<>();
        for(Long g:keys){
            resultSet.add(shortener.getString(g));
        }
        return resultSet;
    }

    static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> testStringsSet = new HashSet<>();
        for (long i=0L;i<elementsNumber;i++) {
            testStringsSet.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Long start = new Date().getTime();
        Set<Long> testGetIds = getIds(shortener,testStringsSet);
        Long end = new Date().getTime();
        Helper.printMessage(String.valueOf(end-start));

        Long start1 = new Date().getTime();
        Set<String> testGetStrings = getStrings(shortener,testGetIds);
        Long end1 = new Date().getTime();
        Helper.printMessage(String.valueOf(end1-start1));

        if (testStringsSet.equals(testGetStrings)){
            Helper.printMessage("Тест пройден.");
        } else
            Helper.printMessage("Тест не пройден.");
    }
}
/*Первая стратегия готова, пришло время ее протестить. Для этого:
6.1. Создай класс Solution, если ты не сделал это раньше.
6.2. Добавь в класс Solution реализации вспомогательных статических методов:
6.2.1. Set<Long> getIds(Shortener shortener, Set<String> strings). Этот метод должен для переданного множества
строк возвращать множество идентификаторов. Идентификатор для каждой отдельной строки нужно получить, используя shortener.
6.2.2. Set<String> getStrings(Shortener shortener, Set<Long> keys). Метод будет возвращать множество строк, которое соответствует переданному множеству идентификаторов.
При реальном использовании Shortener, задача получить из множества строк множество идентификаторов и наоборот скорее всего не встретится, это нужно исключительно для тестирования.
6.2.3. testStrategy(StorageStrategy strategy, long elementsNumber). Метод будет тестировать работу переданной стратегии на определенном количестве элементов elementsNumber. Реализация метода должна:
6.2.3.1. Выводить имя класса стратегии. Имя не должно включать имя пакета.
6.2.3.2. Генерировать тестовое множество строк, используя Helper и заданное количество элементов elementsNumber.
6.2.3.3. Создавать объект типа Shortener, используя переданную стратегию.



6.2.3.4. Замерять и выводить время необходимое для отработки метода getIds
 для заданной стратегии и заданного множества элементов. Время вывести в миллисекундах.
 При замере времени работы метода можно пренебречь переключением процессора на другие потоки, временем,
 которое тратится на сам вызов, возврат значений и вызов методов получения времени (даты). Замер времени произведи с использованием объектов типа Date.
6.2.3.5. Замерять и выводить время необходимое для отработки метода getStrings для заданной стратегии и полученного в предыдущем пункте множества идентификаторов.

6.2.3.6. Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано и множества, которое было возвращено методом getStrings.
 Если множества одинаковы, то выведи "Тест пройден.", иначе "Тест не пройден.".
6.2.4. Добавь метод main(). Внутри метода протестируй стратегию HashMapStorageStrategy с помощью 10000 элементов.
6.3. Проверь, что программа работает и тест пройден.


Требования:
1. Метод getIds должен для переданного множества строк возвращать множество идентификаторов.
2. Метод getStrings должен для переданного множества идентификаторов возвращать множество строк.
3. Метод testStrategy должен выводить на экран имя класса стратегии.
4. Метод testStrategy должен генерировать тестовое множество строк используя метод generateRandomString класса Helper (количество элементов должно быть равно параметру elementsNumber).
5. Метод testStrategy должен создавать объект типа Shortener используя переданную стратегию.
6. Метод testStrategy должен замерять количество времени выполнения методов getIds и getStrings используя объекты типа Date.
7. Метод testStrategy должен сравнивать количество сгенерированных строк и строк в множестве полученном в результате работы метода getStrings и выводить на экран результат прохождения теста.
8. В методе main должен быть вызван метод testStrategy.*/