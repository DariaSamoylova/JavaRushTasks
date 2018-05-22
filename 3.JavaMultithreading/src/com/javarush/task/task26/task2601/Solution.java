package com.javarush.task.task26.task2601;

import java.lang.reflect.Array;
import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
     /*   Integer[] t = new Integer[20];
        int j=0;
for(int i=20;i<40;i++){
    t[j]=i+ (int)(Math.random()*10);
    System.out.println("el j"+j+" = "+t[j]);
    j++;


}
        Integer[] res =    sort(t);
for(Integer pp:res) {
    System.out.println("result:" + pp);
}*/
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here

        Integer[] newArr = array;
        Arrays.sort(newArr);
        int sred = newArr.length/2;
     //   Integer sredZnach = newArr[sred];

      double  sredZnach;
        if(array.length % 2 == 1)
            sredZnach = array[sred];
        else
            sredZnach = ( array[sred-1] + array[sred] ) / 2.0;



        ArrayList<Integer> arr = new ArrayList();
     //   System.out.println("sred="+sred+", sredZnach="+sredZnach);
     //   System.out.println("after  sort");
        for (int i=0;i<newArr.length;i++){
            arr.add(newArr[i]);
          //  System.out.println(arr.get(i));
        }

        Comparator<Integer> compareByM = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(sredZnach-o1)>Math.abs(sredZnach-o2)) return 1;
                else if (Math.abs(sredZnach-o1)<Math.abs(sredZnach-o2)) return -1;
               else
                return 0;
            }
        };

        Collections.sort(arr, compareByM);
       // System.out.println("after Med sort");
        for (int i=0;i<newArr.length;i++){
           // System.out.println(arr.get(i));
            newArr[i]=arr.get(i);
        }

        return newArr;
    }
}


/*Почитать в инете про медиану выборки
Реализуй логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы.
Верни отсортированный массив от минимального расстояния до максимального.
Если удаленность одинаковая у нескольких чисел, то сортируй их в порядке возрастания.

Пример входящего массива:
13, 8, 15, 5, 17
медиана - 13

Отсортированный масив:
13, 15, 17, 8, 5


Требования:
1. Программа не должна выводить текст в консоль.
2. Программа не должна считывать данные с консоли.
3. Класс Solution должен содержать публичный статический метод Integer[] sort(Integer[] array).
4. Метод sort(Integer[] array) класса Solution должен сортировать данные в массиве по удаленности от его медианы.*/