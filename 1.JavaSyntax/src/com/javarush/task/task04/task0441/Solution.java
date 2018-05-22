package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());
        if (((a>=b)&&(b>=c))||((c>=b)&&(b>=a))) {
            System.out.print(b);
        }
       else if (((a>=c)&&(c>=b))||((b>=c)&&(c>=a))) {
            System.out.print(c);
        }
       else if (((c>=a)&&(a>=b))||((b>=a)&&(a>=c))) {
            System.out.print(a);
        }
    }
}
