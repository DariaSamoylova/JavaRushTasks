package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));


           int   a = Integer.parseInt(r.readLine());
       if (a<=0) throw new Exception();

        int   b = Integer.parseInt(r.readLine());
        if (b<=0) throw new Exception();

        int i=(a>b?a:b);
        while(true){
            if ((a%i)==0&&(b%i)==0){
                System.out.println(i);
                break;
            }
            i--;
        }


    }
}
/*НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.


Требования:
1. Программа должна считывать с клавиатуры 2 строки.
2. В случае если введенные строки невозможно преобразовать в положительные целые числа, должно возникать исключение.
3. Программа должна выводить данные на экран.
4. Программа должна выводить на экран наибольший общий делитель(НОД) чисел считанных с клавиатуры и успешно завершаться.*/