package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in) );
        String a = r.readLine();
        int b = Integer.parseInt(r.readLine());
        while (b>0) {
            System.out.println(a);
            b--;
        }
    }
}
