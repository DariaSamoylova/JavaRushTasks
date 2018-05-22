package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i =0;i<5;i++) {
            map.put("q"+i,i);
        }
        map.put("q33",100);
        map.put("q353",1005);
        map.put("q343",1040);
        map.put("q333",1060);
        map.put("q323",1800);

      return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copy = new  HashMap<String, Integer>(map);
        for(Map.Entry<String, Integer> pair: copy.entrySet()){
            if (pair.getValue()<500) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}

/*Только для богачей
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: «фамилия» — «зарплата».
Удалить из словаря всех людей, у которых зарплата ниже 500.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только три метода.
4. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Integer состоящих из 10 записей по принципу «фамилия» - «зарплата».
5. Метод removeItemFromMap() должен удалять из словаря всех людей, у которых зарплата ниже 500.*/