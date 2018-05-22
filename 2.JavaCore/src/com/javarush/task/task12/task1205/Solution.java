package com.javarush.task.task12.task1205;

/* 
Определимся с животным
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //Напишите тут ваше решение
if (o instanceof Cow ) return "Корова";
else if (o instanceof Whale ) return "Кит";
else if (o instanceof Dog ) return "Собака";
        return "Неизвестное животное";
    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}
/*Определимся с животным
Написать метод, который определяет, объект какого класса ему передали, и возвращает результат – одно значение из: «Корова», «Кит», «Собака», «Неизвестное животное».


Требования:
1. Программа должна выводить текст на экран.
2. Класс Cow менять нельзя.
3. Класс Dog менять нельзя.
4. Класс Whale менять нельзя.
5. Класс Pig менять нельзя.
6. Метод getObjectType() должен возвращать одно значение из: «Корова», «Кит», «Собака», «Неизвестное животное» в зависимости от переданного объекта. Например "Корова" для объектов типа Solution.Cow.*/