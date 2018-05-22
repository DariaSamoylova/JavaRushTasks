package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] s = new Solution[2];
        s[0] = new Solution();
        s[0].innerClasses[0] =s[0].new InnerClass();
        s[0].innerClasses[1] =  s[0].new  InnerClass();
        s[1] = new Solution();
        s[1].innerClasses[0] =s[1].new InnerClass();
        s[1].innerClasses[1] = s[1].new InnerClass();
        return s;
    }

    public static void main(String[] args) {

    }
}
/*Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.


Требования:
1. В классе Solution должен быть реализован метод getTwoSolutions.
2. Метод getTwoSolutions должен быть статическим.
3. Метод getTwoSolutions должен быть публичным.
4. Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.*/