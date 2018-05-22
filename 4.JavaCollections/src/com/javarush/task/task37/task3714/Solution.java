package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
     //  System.out.println(   romanToInteger("MCMLXXXVIII"));
    }

    public static int romanToInteger(String s) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)) {
                case 'I':arrayList.add(1);break;
                case 'V':arrayList.add(5);break;
                case 'X':arrayList.add(10);break;
                case 'L':arrayList.add(50);break;
                case 'C':arrayList.add(100);break;
                case 'D':arrayList.add(500);break;
                case 'M':arrayList.add(1000);break;
            }
        }
        int sum=arrayList.get(arrayList.size()-1),a,b;
        for(int i=arrayList.size()-1;i>0;i--){
            a=arrayList.get(i);
            b=arrayList.get(i-1);
            if (b>=a)
                sum=sum+b;
            else
                sum=sum-b;
        }
        return sum;
    }
}
/*Древний Рим
Амиго, привет! Я недавно увлекся историей вашей планеты и меня заинтересовал период Древнего Рима.
Интересно тогда было жить, сплошные развлечения и вино! Или рабство, если не повезло со стартовой локацией...

В общем, мне нужен метод romanToInteger, который будет конвертировать число в римской системе счисления {I, V, X, L, C, D, M} в десятичную. Иначе никак не разобрать что и когда у них происходило.
1	I	лат. unus, unum
5	V	лат. quinque
10	X	лат. decem
50	L	лат. quinquaginta
100	C	лат. centum
500	D	лат. quingenti
1000	M	лат. mille

Требования:
1. Метод romanToInteger должен конвертировать число в римской системе счисления в десятичную.
2. Метод romanToInteger должен возвращать значение типа int и принимать один параметр типа String.
3. Метод romanToInteger должен быть публичным.
4. Метод romanToInteger должен быть статическим.*/