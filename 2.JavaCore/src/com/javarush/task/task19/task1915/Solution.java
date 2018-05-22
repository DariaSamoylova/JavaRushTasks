package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;


public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
      BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
       String f = r.readLine();
        r.close();
         //   String f="c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";

        PrintStream oldOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(outputStream);
        System.setOut(newOut);
        testString.printSomething();
  //   String str = outputStream.toString();
        FileOutputStream strOut = new FileOutputStream(f);
       strOut.write(outputStream.toByteArray());
       // PrintStream out = new PrintStream(strOut);
      //  out.print(str);
/*String result = outputStream.toString();
PrintStream out = new PrintStream(writer);
out.print(result);*/

        System.setOut(oldOut);
        System.out.println( outputStream.toString());

      //  testString.printSomething();

        strOut.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

/*Дублируем текст
Считай с консоли имя файла.
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна дублировать вывод всего текста в файл, имя которого ты считал.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.
Закрой поток файла.

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing


Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строку "it's a text for testing".
5. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
6. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
7. Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream c параметром конструктора ByteArrayOutputStream).
8. Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль объекта System.out.
9. Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
10. Метод main(String[] args) класса Solution должен записывать в файл строку выведенную методом printSomething() (используй FileOutputStream), и дублировать её в консоль.
11. Поток записи в файл (FileOutputStream) должен быть закрыт.*/