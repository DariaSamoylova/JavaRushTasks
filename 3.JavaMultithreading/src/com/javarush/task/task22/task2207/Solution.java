package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
работает верно
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String f1 = r.readLine();
        r.close();
           //  String f1 = "c:\\Users\\mr_ma\\Documents\\Даша\\java\\1.txt";
        StringBuilder strBuild = new StringBuilder();

      //  BufferedReader rF = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));
      //  rF.r
        FileReader fR = new FileReader(f1);

        ArrayList<String> a = new ArrayList<>();
       // FileReader str = new FileReader(f);
        int bukva;

        while (fR.ready()) {
            bukva = fR.read();
            if (bukva == 32||bukva == 10) {
                a.add(strBuild.toString());
                strBuild = new StringBuilder();
            } else  if (bukva != 13&&bukva!=10&&bukva!=32)
                strBuild.append((char) bukva);

        }
        a.add(strBuild.toString());

        fR.close();
      /*  for(String g:a){
            System.out.println("g="+g);
        }*/
        String v;
        for(String g:a){
            v= new StringBuilder(g).reverse().toString();
          //  System.out.println("strBuild="+strBuild);
            for(String g1:a) {
              //  System.out.println("  g1="+g1);
                if (g1.equals(v)){
              //      System.out.println("  g1="+g1);

                    Pair k = new Pair();
                    k.first=g;
                    k.second=g1;
                    Pair k2 = new Pair();
                    k2.second= g;
                    k2.first= g1;
                    if (!result.contains(k)&&!result.contains(k2))
                        result.add(k);
                }
            }
        }
        /*qwe
ewq
wer
rew
ert
rty
tre
dfg
vbnb
      for(Pair rr:result){
            System.out.println(rr);
        } */
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
/*бращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Использовать StringBuilder.

Пример содержимого файла
рот тор торт о
о тот тот тот

Вывод:
рот тор
о о
тот тот


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе main должен быть использован StringBuilder
3. Список result должен быть заполнен корректными парами согласно условию задачи.
4. В классе Solution должен содержаться вложенный класс Pair.
5. В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).*/