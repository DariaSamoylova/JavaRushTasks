package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
           String f1 = r.readLine();
           String f2 = r.readLine();
          r.close();

      //  String f1 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";
      //  String f2 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\3.txt";
        FileInputStream str = new FileInputStream(f1);
        FileOutputStream out = new FileOutputStream(f2);

        int chislo;
        char c;
        String all="";
        String num = "";

        Pattern p = Pattern.compile("^1-9|\\.$");
        Matcher m;




        while (str.available() > 0) {
            c = (char) str.read();

            all = all + c;
            System.out.println("all=" + all);
        }


        String[] tmp = all.split(" ");

        for(String g:tmp){
            chislo = Math.round(Float.valueOf(g));
           char[] array= String.valueOf(chislo).toCharArray();
           for(int i=0;i<array.length;i++){
               System.out.println("byte=" + (byte)array[i]);
               out.write((byte)array[i]);
           }
            out.write((byte)' ');
         //   System.out.println("f=" + chislo);
           // System.out.println("Byte=" + Integer. chislo);
          //  out.write(Byte.valueOf(String.valueOf(f)));
          //  out.write(Byte.valueOf(" "));
        }
          /*  m = p.matcher(String.valueOf(c));

            if (m.matches()) {

                num = num + String.valueOf(c);
                System.out.println( "num="+num);
            } else {
             //   System.out.println( "matches="+String.valueOf(c));
                f = Math.round(Float.valueOf(num));
                System.out.println( "f="+f);
                out.write(Byte.valueOf(String.valueOf(f)));
                out.write(Byte.valueOf(" "));
                num = "";
            }

        }*/

        str.close();
        out.close();
    }
}
/*Округление чисел
123.5 156.2
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.
c:\Users\mr_ma\Documents\Даша\java\1.txt
Принцип округления:
3.49 — 3
3.50 — 4
3.51 — 4
-3.49 — -3
-3.50 — -3
-3.51 — -4


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.*/