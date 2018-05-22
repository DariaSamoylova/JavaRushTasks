package com.javarush.task.task21.task2106;

import java.util.Date;

/* 
Ошибка в equals/hashCode
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null)             return false;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date != null) return false;
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution != null) return false;
        if (string != null ? !string.equals(solution1.string) : solution1.string != null) return false;

        return true;
    }
/*    public boolean equals(Object n) {
      //  return n.first.equals(first) && n.last.equals(last);


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
    }*/
    @Override
    public int hashCode() {
        int result;
        long temp;
       // result = anInt;
        result=anInt+(int)aDouble;
      //  temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
      //  result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
     //   result = 31 * result + anInt.hashCode() : 0);
        result = 31 * result + (string != null ? string.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
      //  result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
        /*  private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;*/
    }

    public static void main(String[] args) {

    }
}
/*Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution.


Требования:
1. Хешкоды одинаковых объектов должны быть равны.
2. Метод equals должен проверять равен ли переданный объект равен текущему (сравнение через ==).
3. Метод equals должен проверять является ли переданный объект объектом класса Solution.
4. Метод equals должен проверять значения всех полей у переданного объекта и текущего (учти что некоторые из них могут быть равны null).
5. Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
6. В классе Solution должен быть реализован метод hashCode.*/