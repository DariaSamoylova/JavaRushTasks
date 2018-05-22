package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName   = args[1];//"c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";//
        String  fileOutputName=args[2];// "c:\\Users\\mr_ma\\Documents\\Даша\\java\\2.txt";//args[2];
       // args=new String[1];
      //  args[0]="-d";
        FileInputStream strIn = new FileInputStream(fileName);
        FileOutputStream strOut = new FileOutputStream(fileOutputName);
        int b;


        if (args[0].equals("-e")){
            while(strIn.available()>0){
                b= strIn.read();
                strOut.write(b);
                strOut.write(1);
            }




        } else   if (args[0].equals("-d")){
            while(strIn.available()>0) {
                b = strIn.read();
                strOut.write(b);
                strIn.read();
            }
        }

        strIn.close();
        strOut.close();
    }

}
/*Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName — имя файла, который необходимо зашифровать/расшифровать.
fileOutputName — имя файла, куда необходимо записать результат шифрования/дешифрования.
-e — ключ указывает, что необходимо зашифровать данные.
-d — ключ указывает, что необходимо расшифровать данные.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.*/