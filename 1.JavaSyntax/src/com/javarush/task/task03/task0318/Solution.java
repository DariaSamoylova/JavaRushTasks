package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream i = System.in;
        Reader ri = new InputStreamReader(i);
        BufferedReader b = new BufferedReader(ri);
        String an = b.readLine();
        String n = b.readLine();

        int aa = Integer.parseInt(an);
System.out.print(n+" захватит мир через "+aa+ " лет. Му-ха-ха!");



    }
}
