package com.javarush.task.task34.task3404;

import java.util.ArrayList;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
     //   solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
       // solution.recursion("sin(2)", 0); //expected output 0.5 6
        System.out.println(Integer.parseUnsignedInt("1+2"));
    }

    public void recursion(final String expression, int countOperation) {
        int brack_start = expression.lastIndexOf("(");
        int brack_end = expression.indexOf(")");
      //  System.out.println(brack_start+"---" +brack_end);
     //   String new_expres = expression.substring(0,brack_start)+expression.substring(brack_end);
        String curr_expr=expression.substring(brack_start+1,brack_end);
                 System.out.println(curr_expr);
    //    boolean pologitel = expression.charAt(0)=='-'?false:true;
     //   if (!pologitel)
       //     curr_expr=curr_expr.substring(1);
        boolean digit=true;
        double result_expression;
        int operation;
        ArrayList<String> list = new ArrayList<>();
       // if (curr_expr..contains("*"))
      //      Integer.
        String currSymb;
        for(int i=0;i<curr_expr.length();i++){
            if (curr_expr.charAt(i)=='-')
                currSymb="-"  ;

            else if (curr_expr.charAt(i)=='+')
                operation=1;
            else   if (curr_expr.charAt(i)=='-')
                operation=1;
            else   if (curr_expr.charAt(i)=='+')
                operation=1;
            else   if (curr_expr.charAt(i)=='+')
                operation=1;
            if (!Character.isDigit(curr_expr.charAt(i))){
                digit=false;
                //break;
            }
        }
        char bef;
        char befbef;
        if (digit){
          /*  bef= expression.charAt(brack_start-1);
            if
            if (bef=='n'){
                befbef=expression.charAt(brack_start-2);
            }
            System.out.println(bef);*/
          return;
        }

       /* String curr="";
        for(int i=0;i<expression.length();i++){


        boolean pologitel = expression.charAt(0)=='-'?false:true;
        if (!pologitel){
            curr="-"; continue;
        } else (
                if (Character.isDigit(expression.charAt(i)){
                    curr=curr+ expression.charAt(i);
            }
            else */
        //implement
    }

    public Solution() {
        //don't delete
    }
}
/*Рекурсия для мат. выражения
На вход подается строка - математическое выражение.
Выражение включает целые и дробные числа, скобки (), пробелы, знак отрицания -, возведение в степень ^, sin(x), cos(x), tan(x)
Для sin(x), cos(x), tan(x) выражение внутри скобок считать градусами, например, cos(3 + 19*3)=0.5
Степень задается так: a^(1+3) и так a^4, что эквивалентно a*a*a*a.
С помощью рекурсии вычислить выражение и количество математических операций. Вывести через пробел результат в консоль.
Результат выводить с точностью до двух знаков, для 0.33333 вывести 0.33, использовать стандартный принцип округления.
Не создавай в классе Solution дополнительные поля.
Не пиши косвенную рекурсию.

Пример, состоящий из операций sin * - + * +:
sin(2*(-5+1.5*4)+28)

Результат:
0.5 6


Требования:
1. В классе Solution не должны быть созданы дополнительные поля.
2. Метод recursion должен выводить на экран результат вычисления заданного выражения (пример в условии).
3. Метод recursion не должен быть статическим.
4. Метод recursion должен быть рекурсивным.*/