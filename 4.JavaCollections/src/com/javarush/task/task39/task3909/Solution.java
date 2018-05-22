package com.javarush.task.task39.task3909;

import java.util.*;

/*
Одно изменение
*/
//валидатор не проходит....рабочее решение

public class Solution {

    public static void main(String[] args) {
        System.out.println(isOneEditAway("",""));
        System.out.println(isOneEditAway(null,""));
        System.out.println(isOneEditAway("q",""));
        System.out.println(isOneEditAway("q","qw"));
        System.out.println(isOneEditAway("qweqwe","qweqwe"));
        System.out.println(isOneEditAway("qweqwe","qweewe"));
        System.out.println(isOneEditAway("qweqwe","qwe1qwe"));
        System.out.println(isOneEditAway("qwe12qwe","qwe1qwe"));
        System.out.println(isOneEditAway("am","m"));
    }

    public static boolean isOneEditAway(String first, String second) {

if (first==null||second==null||Math.abs(first.length()-second.length())>1)
        return  false;
if (first.equals(second))
    return true;
        if (first.equals("") && second.equals(""))
            return true;
if ((first.length()==1||second.length()==1)&& first.length()!=second.length())
    return true;
if (first.length()==second.length()){
    int flag=0;
    for(int i=0;i<first.length();i++){
        if (first.charAt(i)!=second.charAt(i))
            flag++;

    }
    if (flag==1) return true;
    else  return  false;
} else
{
    StringBuffer sb1or = new StringBuffer(first);
    StringBuffer sb2or = new StringBuffer(second);

    StringBuffer sb1 = new StringBuffer(first);
    StringBuffer sb2 = new StringBuffer(second);


    for(int i=0;i<(sb1or.length()>sb2or.length()?sb1or.length():sb2or.length());i++){
        if (sb1or.charAt(i)!=sb2or.charAt(i)) {
            sb1.deleteCharAt(i);
            if (sb1.toString().equals(sb2or.toString())) return true;
            sb2.deleteCharAt(i);
            if (sb2.toString().equals(sb1or.toString())) return true;
            return false;
        }

    }

}
        return false;

    }
}
/*
qweqwe
qwqwe
Одно изменение
Реализуй метод isOneEditAway(String first, String second) который будет возвращать true, если возможно изменить/добавить/удалить один символ в одной из строк и получить другую.

Символы в анализируемой строке ограничены кодировкой ASCII.
Регистр символов учитывается.


Требования:
1. Метод isOneEditAway должен корректно работать для строк одинаковой длины.
2. Метод isOneEditAway должен корректно работать для строк разной длины.
3. Метод isOneEditAway должен корректно работать для пустых строк.
4. Метод isOneEditAway должен быть публичным.*/