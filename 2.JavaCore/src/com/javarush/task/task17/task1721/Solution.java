package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String f1=r.readLine();
        String f2=r.readLine();
        r.close();
        BufferedReader f_r1 = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));
        String g;
        while(true){
            g=f_r1.readLine();
            if (g==null) break;
            allLines.add(g);
        }
        f_r1.close();
        String g1;
        BufferedReader f_r2 = new BufferedReader(new InputStreamReader(new FileInputStream(f2)));
        while(true){
            g1=f_r2.readLine();
            if (g1==null) break;
            forRemoveLines.add(g1);
        }
        f_r2.close();
        Solution solution = new Solution();
try {
    solution.joinData();
} catch (Exception e){
    System.out.println(e);
}

     /*   for(String h:allLines){
            System.out.println(h);
        }
        System.out.println("--");
        for(String h:forRemoveLines){
            System.out.println(h);
        }*/
    }
//c:\Users\mr_ma\Documents\Даша\java\1.txt
    //c:\Users\mr_ma\Documents\Даша\java\2.txt
    public  void joinData () throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }


    }
}
/*Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла — в allLines, из второго — в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.


Требования:
1. Класс Solution должен содержать public static поле allLines типа List.
2. Класс Solution должен содержать public static поле forRemoveLines типа List.
3. Класс Solution должен содержать public void метод joinData() который может бросать исключение CorruptedDataException.
4. Программа должна считывать c консоли имена двух файлов.
5. Программа должна считывать построчно данные из первого файла в список allLines.
6. Программа должна считывать построчно данные из второго файла в список forRemoveLines.
7. Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в allLines содержаться все строки из списка forRemoveLines.
8. Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если в allLines не содержаться все строки из списка forRemoveLines.
9. Метод joinData должен вызываться в main.*/