package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String f = r.readLine();
        r.close();


        FileInputStream str = new FileInputStream(f);
        // ArrayList<Integer> a = new ArrayList<>();
       // HashMap<Integer,Integer> h = new HashMap<>();
HashSet<Integer> h = new HashSet();

        while (str.available()>0){
            h.add(str.read());
        }

        int[] arr=new int[h.size()];
        int y=0;
        for(int t:h){
            arr[y]=t;
            y++;
        }
        int swap;
        for(int i=0;i<h.size();i++){

            for(int j = 0;j<h.size();j++){
                if (arr[i]<arr[j]){
                    swap=arr[i];
                    arr[i]=arr[j];
                    arr[j]=swap;
                }
            }
        }

        for(int j = 0;j<arr.length;j++) {
        System.out.print(arr[j]+" ");
        }

        str.close();
    }
}
/*Сортировка байт
c:\Users\mr_ma\Documents\Даша\java\1.txt
Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений — отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.

Пример байт входного файла:
44 83 44

Пример вывода:
44 83


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.*/