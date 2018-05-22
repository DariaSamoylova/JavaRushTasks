package com.javarush.task.task19.task1921;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {

         String f = args[0];
       //  String f = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";
      //  FileReader r = new FileReader(f);

        StringBuilder strBuild = new StringBuilder();
        ArrayList<String> a = new ArrayList<>();
        FileReader str = new FileReader(f);
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

      /*         for(String g:a){
            System.out.println(g);
        }*/

        String[] stroka;
        String name,date;
        Pattern p = Pattern.compile("\\d+");
      //  System.out.println();

        Matcher m;
        for (int i = 0; i < a.size(); i++) {
            name="";date="";
          //  System.out.println("a="+a.get(i));
            stroka = a.get(i).split(" ");

            for(int y=0;y<stroka.length;y++){
             //   System.out.println("y="+y+" stroka="+stroka[y]);
                m=p.matcher(stroka[y]);
                if (!m.matches()) {
                  //  System.out.println("name");
                    name = name + stroka[y] + " ";
                 //   System.out.println("name=" + name);
                }
                else {
                  //  System.out.println("date");
                    date = date + stroka[y] + " ";
                  //  System.out.println("date=" + date);
                }
            }

           // System.out.println("name="+name+", date="+date);
           //  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
            //  System.out.println("date: " + dateFormat.format( new Date() ) );
           SimpleDateFormat dateFormat = new SimpleDateFormat("dd M yyyy");
         PEOPLE.add(new Person(name.substring(0,name.length()-1), dateFormat.parse(date)));

        }

      //  for (Person s:PEOPLE){
      //      System.out.println(s.getBirthday()+" "+s.getName());
      //  }
    }
}
/*Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] — может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] — int, [месяц] — int, [год] — int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
6. Программа должна правильно работать с двойными именами, например Анна-Надежда.*/