package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

       BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String f = r.readLine();
        r.close();
      //  String f="c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";

         if (args[0].equals("-c")){
          //   FileInputStream strIn = new FileInputStream(f);
          //   BufferedWriter  strOut= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));

             BufferedReader strIn = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String last="",check;


            while(true){
                check=strIn.readLine();

                if (check==null) break; else last=check;
            }
      //  System.out.println("last="+last);
             int id=Integer.parseInt(last.substring(0,8))+1;
      //  System.out.println("id="+id);
             String newId = String.valueOf(id);
            String newWrite;
             if (newId.length()>8){
                 newId = newId.substring(0,7);
             } else if (newId.length()<8) {
                 while (newId.length() < 8) {
                     newId=newId+" ";
                 }
             }


             String productName=args[1];//"Куртка ";//
             if (productName.length()>30){
                 productName = productName.substring(0,30);
             } else if (productName.length()<30) {
                 while (productName.length() < 30) {
                     productName=productName+" ";
                 }
             }


             String price=args[2];//"9.00";//
             if (price.length()>8){
                 price = price.substring(0,8);
             } else if (price.length()<8) {
                 while (price.length() < 8) {
                     price=price+" ";
                 }
             }


             String quantity=args[3];//"22";//
             if (quantity.length()>4){
                 quantity = quantity.substring(0,4);
             } else if (quantity.length()<4) {
                 while (quantity.length() < 4) {
                     quantity=quantity+" ";
                 }
             }


             newWrite=newId+productName+price+quantity;
        System.out.println("newWrite="+newWrite);
        byte[] buff=newWrite.getBytes();
        strIn.close();


        FileInputStream strIn1 = new FileInputStream(f);
        byte[] buffer=new byte[strIn1.available()];
        strIn1.read(buffer);
        strIn1.close();

        FileOutputStream strOut = new FileOutputStream(f);
           strOut.write(buffer);
        strOut.write(10);
     //   strOut.write(13);
        strOut.write(buff);

             strOut.close();
         }
    }
}
/*Прайсы
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id — 8 символов.
productName — название товара, 30 chars (60 bytes).
price — цена, 8 символов.
quantity — количество, 4 символа.
-c — добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846   Шорты пляжные синие           159.00 12
198478  Шорты пляжные черные с рисунко173.00 17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
4. Товар должен иметь следующий id, после максимального, найденного в файле.
5. Форматирование новой строки товара должно четко совпадать с указанным в задании.
6. Созданные для файлов потоки должны быть закрыты.*/