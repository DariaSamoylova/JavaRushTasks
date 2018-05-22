package com.javarush.task.task26.task2603;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements  Comparator<T>{
      private   Comparator<T>[] comparators;
        public  CustomizedComparator(Comparator<T>... vararg){
            this.comparators = vararg;
        }


      /*  public int compare() {
           for(int i=0;i<comparators.length;i++){
               comparators[i].compare(T o1, T o2)
           }
        }*/

        @Override
        public int compare(T o1, T o2) {
            int res=0;
            for(int i=0;i<comparators.length;i++){
                res=comparators[i].compare(o1,o2);
                if (res!=0) break;
            }
            return res;
        }
    }
}

/*Убежденному убеждать других не трудно
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напиши public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать массив компараторов.
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т.
В конструктор передается как минимум один компаратор.


Требования:
1. Класс Solution должен содержать public static компаратор CustomizedComparator.
2. Класс CustomizedComparator должен содержать приватное поле comparators типа Comparator[].
3. Класс CustomizedComparator должен содержать конструктор с параметром vararg компараторов.
4. Метод compare() класса CustomizedComparator должен сравнивать объекты в порядке, соответствующем последовательности компараторов comparators.*/