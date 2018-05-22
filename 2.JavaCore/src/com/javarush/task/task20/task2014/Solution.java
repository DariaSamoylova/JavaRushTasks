package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));
        Solution savedObjectSolution= new Solution(2);

         String your_file_name = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";
        FileOutputStream fileOutput = new FileOutputStream(your_file_name);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(savedObjectSolution);
        fileOutput.close();
        outputStream.close();

        //load cat from file
        FileInputStream fiStream = new FileInputStream(your_file_name);
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Solution loadedObject = (Solution)objectStream.readObject();
        fiStream.close();
        objectStream.close();

        System.out.println(savedObjectSolution.string);
        System.out.println(loadedObject.string);

    }
/*FileOutputStream fileOutput = new FileOutputStream("cat.dat");
 ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
 outputStream.writeObject(cat);
 fileOutput.close();
 outputStream.close();

 //load cat from file
 FileInputStream fiStream = new FileInputStream("cat.dat");
 ObjectInputStream objectStream = new ObjectInputStream(fiStream);
 Object object = objectStream.readObject();
 fiStream.close();
 objectStream.close();*/
    transient  private final String pattern = "dd MMMM yyyy, EEEE";
    transient   private Date currentDate;
    transient   private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
/*Serializable Solution
Сериализуй класс Solution.
Подумай, какие поля не нужно сериализовать, пометь ненужные поля модификатором transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.

Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream);
2) создать экземпляр класса Solution — savedObject;
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть);
4) создать другой экземпляр класса Solution с другим параметром;
5) загрузить из потока на чтение объект — loadedObject;
6) проверить, что savedObject.string равна loadedObject.string;
7) обработать исключения.


Требования:
1. Поле pattern должно быть отмечено модификатором transient.
2. Поле currentDate должно быть отмечено модификатором transient.
3. Поле temperature должно быть отмечено модификатором transient.
4. Поле string НЕ должно быть отмечено модификатором transient.*/