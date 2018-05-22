package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

  /*  public boolean equals(Object o) {
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        return n.first.equals(first) && n.last.equals(last);
    }*/
    public boolean equals(Object n) {
        //  return n.first.equals(first) && n.last.equals(last);

        if (this == n)
            return true;
        if (n == null)
            return false;
        if (!(n instanceof Solution))
            return false;
        if (getClass() != n.getClass())
            return false;
        Solution other = (Solution) n;
        if (first != other.first)
            return false;
        if (last != other.last)
            return false;
        return true;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((first!=null)?first.hashCode():0);
        result = prime * result + ((last!=null)?last.hashCode():0) ;
        //  result=first.hashCode()*prime+last.hashCode()*prime;
        return result;
    }
    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
/*Исправить ошибку. Сравнение объектов
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.


Требования:
1. Хешкоды одинаковых объектов должны быть равны.
2. Метод equals должен проверять равен ли переданный объект равен текущему(сравнение через ==).
3. Метод equals должен проверять является ли переданный объект объектом класса Solution.
4. Метод equals должен возвращать true в случае, если поля first и last равны у переданного объекта и текущего(не забудь что они могут быть равны null).
5. Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
6. В классе Solution должен быть реализован метод hashCode.*/