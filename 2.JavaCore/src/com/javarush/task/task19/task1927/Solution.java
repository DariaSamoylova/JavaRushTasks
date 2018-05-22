package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldOut=System.out;
        ByteArrayOutputStream byteArr = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(byteArr);
        System.setOut(newOut);
        testString.printSomething();
        String[] newArray =  byteArr.toString().split("\\n");



        System.setOut(oldOut);
        for(int i=0;i<newArray.length;i++){
            System.out.println(newArray[i]);
            if (i%2==1)  System.out.println("JavaRush - курсы Java онлайн");
        }
     //   System.out.println("nnn"+ byteArr.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
/*PrintStream consoleStream = System.out;

 //Создаем динамический массив
 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
 //создаем адаптер к классу PrintStream
 PrintStream stream = new PrintStream(outputStream);
 //Устанавливаем его как текущий System.out
 System.setOut(stream);

 //Вызываем функцию, которая ничего не знает о наших манипуляциях
 printSomething();

 //Преобразовываем записанные в наш ByteArray данные в строку
 String result = outputStream.toString();

 //Возвращаем все как было
 System.setOut(consoleStream);

 //разворачиваем строку
 StringBuilder stringBuilder = new StringBuilder(result);
 stringBuilder.reverse();
 String reverseString = stringBuilder.toString();

 //выводим ее в консоль
 System.out.println(reverseString);
}

public static void printSomething()
{
 System.out.println("Hi");
 System.out.println("My name is Amigo");
 System.out.println("Bye-bye!");*/
/*Контекстная реклама
В методе main подмени объект System.out написанной тобой реадер-оберткой.
Твоя реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.

Рекламный текст: «JavaRush - курсы Java онлайн»

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth


Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строки: "first","second","third","fourth","fifth".
5. Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream c параметром конструктора ByteArrayOutputStream).
6. Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль объекта System.out.
7. Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
8. Метод main(String[] args) класса Solution должен модифицировать строки(вставлять контекстную рекламу) выведенные методом printSomething() согласно заданию, и выводить её в консоль.*/