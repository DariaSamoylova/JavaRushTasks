package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

/*
Составить цепочку слов
*/
public class Solution {
 //  static HashMap<String,Boolean> allWords = new HashMap<>();

    public static void main(String[] args) throws IOException {
        //...
         BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String f1 = r.readLine();

        r.close();

  //    String f1 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";

        StringBuilder strBuild = new StringBuilder();
       ArrayList<String> allSet = new ArrayList<>();
        FileReader str = new FileReader(f1);
        int bukva;

        while (str.ready()) {
            bukva = str.read();
            if (bukva == 10||bukva == 32) {
            //    allWords.put(strBuild.toString(),true);
                allSet.add(strBuild.toString());
                strBuild = new StringBuilder();
            } else if (bukva != 13)
                strBuild.append((char) bukva);

        }
       // allWords.put(strBuild.toString(),true);
        allSet.add(strBuild.toString());

        str.close();
       String[] allWordsArray= new String[allSet.size()];
       int i=0;
       for(String h:allSet){
     //      System.out.println(h);
           allWordsArray[i]=h;
           i++;
       }
    //    System.out.println();
       StringBuilder result = getLine(allWordsArray);
         System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        if( words.length>0) {
            char b;
            Arrays.sort(words);
            ArrayList<String> arr = new ArrayList<>();//ArrayList) Arrays.asList(words);
            for (String h : words) {
                arr.add(h);
            }
       /*  for(String h:arr){
            System.out.println(h);
        }
        System.out.println();*/

            result.append(arr.get(0)).append(" ");
            b = arr.get(0).charAt((arr.get(0).toLowerCase()).length() - 1);
          //  System.out.println(b);
            arr.remove(0);
            //   int i=0;
            boolean flag=true;
            while (!arr.isEmpty()&&flag) {

                Pattern p = Pattern.compile("^" + b + ".*");

                for (int i = 0; i < arr.size(); i++) {
                    if (p.matcher((arr.get(i).toLowerCase())).matches()) {
                        result.append(arr.get(i)).append(" ");
                        b = arr.get(i).charAt((arr.get(i).toLowerCase()).length() - 1);
                    //    System.out.println("cikl:"+b);
                        arr.remove(i);
                        flag=true;
                        break;
                    } else
                        flag=false;
                }


            }
           // int i=0;
            while (!arr.isEmpty()){
                result.append(arr.get(0)).append(" ");
                arr.remove(0);
              //  i++;
            }
            if (result != null) {
                result.deleteCharAt(result.length() - 1);
            }
        }
          return result;
    }
}
/*Составить цепочку слов
В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставь все слова в таком порядке, чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе getLine должен быть использован StringBuilder
3. Метод getLine должен возвращать пустую строку(пустой StringBuilder) в случае если ему не были переданы параметры(слова).
4. Все слова переданные в метод getLine должны быть включены в результирующую строку, если это возможно.
5. Вывод на экран должен соответствовать условию задачи.*/