package com.javarush.task.task12.task1217;

/* 
Лететь, бежать и плыть
*/

public class Solution {
    public static void main(String[] args) {

    }

//add interfaces here - добавь интерфейсы тут
public interface   Fly{
      static  void f(){
            int y=1;
        }
}
    public interface   Swim{
        static  void f(){
            int y=1;
        }
    }
    public interface   Run{
        static  void f(){
            int y=1;
        }
    }
}
/*Лететь, бежать и плыть
Напиши public интерфейсы Fly(летать), Run(бежать/ездить), Swim(плавать).
Добавить в каждый интерфейс по одному методу.


Требования:
1. Класс Solution должен содержать интерфейс Fly.
2. Класс Solution должен содержать интерфейс Run.
3. Класс Solution должен содержать интерфейс Swim.
4. Интерфейс Fly должен содержать один метод.
5. Интерфейс Run должен содержать один метод.
6. Интерфейс Swim должен содержать один метод.*/