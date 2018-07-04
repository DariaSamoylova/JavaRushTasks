package com.javarush.task.task22.task2207;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова

мое работает!!но валид не принял
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> words = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
            reader.close();

            while (bufferedReader.ready()) {
                String[] wordsInLine = bufferedReader.readLine().split(" ");
                for (String s : wordsInLine) {
                    words.add(s);
                }
            }
            bufferedReader.close();

            for (String s : words) {
                StringBuilder str = new StringBuilder(s).reverse();
                String secondStr = str.toString();
                boolean isNotSameWord = true;

                Pair pair = new Pair();
                pair.first = secondStr;
                pair.second = s;

                Pair doublepair = new Pair();
                doublepair.first = s;
                doublepair.second = secondStr;
                if (words.contains(secondStr) && !result.contains(pair) && !result.contains(doublepair)) {
                    if (s.equals(secondStr)) {
                        isNotSameWord = false;
                        int x = words.indexOf(s);
                        if (words.lastIndexOf(s) != x) {
                            isNotSameWord = true;
                        }
                    }
                    if (isNotSameWord) {
                        result.add(pair);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


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
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
/*
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String f1 = br.readLine();
        br.close();
     //  String f1 = "c:\\Users\\mr_ma\\Documents\\Dasha\\java\\1.txt";
   //  String f1 = "c:\\Users\\mr_ma\\Documents\\Dasha\\jv\\JavaRushTasks\\3.JavaMultithreading\\src\\com\\javarush\\task\\task22\\task2207\\1";
        //c:\Users\mr_ma\Documents\Dasha\jv\JavaRushTasks\3.JavaMultithreading\src\com\javarush\task\task22\task2207\
      //  BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(f1), StandardCharsets.UTF_8));
        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(f1) ));

        ArrayList<String> allWords = new ArrayList<>();
     //   boolean repl = false;
        while(true){
            String stroka;
            if((stroka=r.readLine())==null)
                break;
          //  if (!repl) {
            //    stroka.substring(1);
          //      repl=true;
        //    }

            String[] slovaVStroke=stroka.split("\\s");
            allWords.addAll(Arrays.asList(slovaVStroke));
        }
r.close();
        for(String word:allWords){
            StringBuilder wordd=new StringBuilder(word);
            StringBuilder worddReverse=new StringBuilder(word);
            worddReverse.reverse();
             String tryy= worddReverse.toString();
            //tryy.replaceAll("[\0]","");
          //  byte[] bytes=tryy.getBytes();
          //  String tryyy=new String(bytes,Charset.forName("UTF-8"));
          //  if (allWords.contains(tryyy)) {
          //  System.out.println(worddReverse.toString());

           // Charset cset = Charset.forName("Unicode");
          //  Charset cset1 = Charset.forName("UTF-8");
          //  ByteBuffer buf = cset.encode(worddReverse.toString());
          //  byte[] b = buf.array();
           // String str = new String(b);
          //  ByteBuffer buff = ByteBuffer.wrap(b);
          //  CharBuffer chbuf = cset1.decode(buff);

          //  String start = chbuf.toString();
            if (allWords.contains(tryy)) {
                Pair pair = new Pair();
                pair.first = wordd.toString();
                pair.second = worddReverse.toString();
                Pair pairRev = new Pair();
                pairRev.first = worddReverse.toString();
                pairRev.second = wordd.toString();
                if (!result.contains(pair)&&!result.contains(pairRev)){
                    result.add(pair);
                }
            }
        }

        for(Pair p:result){
            System.out.println(p);
        }

    }

    public static class Pair {
        String first;
        String second;
public  Pair(){

}

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }
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

}*/
/*Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Использовать StringBuilder.
Кодировка файла - UTF-8.

Пример содержимого файла
рот тор торт о
о тот тот тот

Вывод:
рот тор
о о
тот тот


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе main должен быть использован StringBuilder.
3. В классе Solution должен содержаться вложенный класс Pair.
4. В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
5. Список result должен быть заполнен корректными парами согласно условию задачи.*/