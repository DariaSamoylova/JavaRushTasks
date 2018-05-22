package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
       String f = r.readLine();
        r.close();

      /*  String f="c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
       String f = r.readLine();
        r.close();

      /*  String f="c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";
        args = new String[5];
        args[0] = "-d";
        args[1] = "124";
        args[2] = "1";
        args[3] = "2";
        args[4] = "2";*/


        BufferedReader strIn = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        ArrayList<String> arr = new ArrayList<>();

        if (args[0].equals("-u") || args[0].equals("-d")) {
            String line;
            while (true) {
                line = strIn.readLine();
                if (line == null) break;
                arr.add(line);
            }
            int id;
            String changeStr,q;
            for (int i = 0; i < arr.size(); i++) {
               // System.out.println(arr.get(i)+"-");
              //  System.out.println(arr.get(i).substring(0, 8)+"-");

                 q= arr.get(i).substring(0, 8);
                 if (q.indexOf(" ")>=0) {
                     q = q.substring(0, q.indexOf(" "));
                 }
               // System.out.println(q+"-");
                id = Integer.parseInt(q);
                if (id == Integer.parseInt(args[1])) {
                    if (args[0].equals("-d"))
                        arr.remove(i);
                    if (args[0].equals("-u")) {

                        String newId=args[1];//"Куртка ";//
                        if (newId.length()>8){
                            newId = newId.substring(0,8);
                        } else if (newId.length()<8) {
                            while (newId.length() < 8) {
                                newId=newId+" ";
                            }
                        }

                        String productName=args[2];//"Куртка ";//
                        if (productName.length()>30){
                            productName = productName.substring(0,30);
                        } else if (productName.length()<30) {
                            while (productName.length() < 30) {
                                productName=productName+" ";
                            }
                        }

                        String price=args[3];//"9.00";//
                        if (price.length()>8){
                            price = price.substring(0,8);
                        } else if (price.length()<8) {
                            while (price.length() < 8) {
                                price=price+" ";
                            }
                        }


                        String quantity=args[4];//"22";//
                        if (quantity.length()>4){
                            quantity = quantity.substring(0,4);
                        } else if (quantity.length()<4) {
                            while (quantity.length() < 4) {
                                quantity=quantity+" ";
                            }
                        }

                        arr.set(i,newId+productName+price+quantity);

                    }
break;
                }
            }



            strIn.close();

            FileOutputStream strOut = new FileOutputStream(f);
            for(String g:arr) {
                strOut.write(g.getBytes());
                strOut.write(10);
            }

            strOut.close();
        }

        //  String f="c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";
    }
}
/*Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id

Значения параметров:
где id — 8 символов
productName — название товара, 30 chars (60 bytes)
price — цена, 8 символов
quantity — количество, 4 символа
-u — обновляет данные товара с заданным id
-d — производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
5. Созданные для файлов потоки должны быть закрыты.*/