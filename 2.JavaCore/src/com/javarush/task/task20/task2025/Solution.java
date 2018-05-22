package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
      /*  long[] result = null;
        ArrayList<Long> arrayList = new ArrayList<>();
        for(long i=1;i<N;i++){
            String r = String.valueOf(i);
            int sum=0;
            for(int y=0;y<r.length();y++){
              sum=sum+ (int)Math.pow(  Integer.parseInt( String.valueOf(r.charAt(y))), r.length());

            }
             if (i==sum)
                 arrayList.add(i);
        }

        result =new  long[arrayList.size()];
        for(int j=0;j<arrayList.size();j++){
            result[j]=arrayList.get(j);
        }
        return result;*/



        long[] result = null;
        LinkedList<Long> list = new LinkedList<>();

        // Создаем и инициализируем массив степененй
        long[][] mult = new long[10][19];
        for (int i = 0; i < mult.length; i++) {
            for (int j = 0; j < mult[i].length; j++) {
                long tmp = i;
                int degree = j;
                while (degree-- > 0) {
                    tmp *= i;
                }
                mult[i][j] = tmp;
             //   System.out.println("i="+i+", j="+j+", value="+  mult[i][j]);
            }
        }

        byte bitness_start = 1;
        long length = 10;

        for (long i = 1; i <= N; i++) {
            long tmp = i;
            long res = 0;

            do {
                res += mult[(int)tmp % 10][bitness_start - 1];
                tmp /= 10;
            } while (tmp != 0);

            if (res == i) {
                list.add(i);
            }

            if (i == length) {
                length *= 10;
                bitness_start++;
            }
        }

        result = new long[list.size()];
        int i = 0;
        for (Long value : list) {
            result[i++] = value;
        }        return result;
    }

    public static void main(String[] args) {
//for(long g:getNumbers(Long.MAX_VALUE)){
//    System.out.println(g);
//}

      //  System.out.print(Long.MAX_VALUE);
         getNumbers(Long.MAX_VALUE);
    }
}
/*Число S состоит из M цифр, например, S=370 и M (количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания.

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.


Требования:
1. В классе Solution должен присутствовать метод getNumbers c одним параметром типа long.
2. Метод getNumbers должен быть публичным.
3. Метод getNumbers должен быть статическим.
4. Метод getNumbers должен возвращать массив чисел удовлетворяющих условию задачи.*/