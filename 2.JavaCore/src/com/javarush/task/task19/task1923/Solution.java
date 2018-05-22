package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

      /*  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String file1 = r.readLine();
        String file2 = r.readLine();
        r.close();*/

         // String file1 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";
      //  String file2 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\3.txt";
        String file1 = args[0];
        String file2 = args[1];

        FileReader str = new FileReader(file1);

        StringBuilder strBuild = new StringBuilder();
        ArrayList<String> a = new ArrayList<>();

        int bukva;

        while (str.ready()) {
            bukva = str.read();
            if (bukva == 10) {
                a.add(strBuild.toString());
                strBuild = new StringBuilder();
            } else if (bukva != 13)
                strBuild.append((char) bukva);

        }
        a.add(strBuild.toString());

        str.close();

        String[] stroka;
        StringBuilder resultBuild = new StringBuilder();
        Pattern p = Pattern.compile("[0-9]");
        Matcher m ;
        /*    String g=contact.getPhoneNumber();
            Pattern p = Pattern.compile("[0-9]");
           = p.matcher(g);

            String h="";
            while (m.find()) {
                h=h+m.group();
            }*/
        for (int i = 0; i < a.size(); i++) {

            stroka = a.get(i).split(" ");

            for(int y=0;y<stroka.length;y++){
                m=p.matcher(stroka[y]);

                if (  m.find()){
                    resultBuild.append(stroka[y]).append(" ");
                }
            }

        }

     //   System.out.print(resultBuild);

        FileWriter strOut = new FileWriter(file2);
      //  strOut.write(resultBuild.toString());
        char[] charArr = new char[resultBuild.length()];
       charArr=resultBuild.toString().toCharArray();
        for(int i=0;i<charArr.length;i++){
            strOut.write(charArr[i]);
        }

        strOut.close();
    }
}
/*Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит строки со словами, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.*/