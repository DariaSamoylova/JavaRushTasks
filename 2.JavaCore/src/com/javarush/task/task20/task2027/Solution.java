package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
       List<Word> list =  detectAllWords(crossword, "home", "same","vor");
       for(Word w :list){
           System.out.println(w);
       }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)

oemasu

 1   4
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
//for(int ww=0;ww<words.length;ww++){
        List<Word> resultList = new ArrayList<>();
        for(String ww:words){
   // char[] wordChar = words[ww].toCharArray();
    Word word = new Word(ww);
    boolean wordFound=false;
    for(int i=0;i<crossword.length;i++){
        StringBuffer sb = new StringBuffer();
        for(int y=0;y<crossword[0].length;y++){
            sb.append((char)crossword[i][y]);

        }
        String line=sb.toString();
        if (line.contains(ww)){
           // word.setStartPoint(i,line.indexOf(ww));
            word.setStartPoint(line.indexOf(ww),i);
          //  word.setEndPoint(i,line.indexOf(ww)+ww.length());
            word.setEndPoint(line.indexOf(ww)-1+ww.length(),i);
            resultList.add(word);
            wordFound=true;
            break;
        }
        String lineRev=sb.reverse().toString();
        if (lineRev.contains(ww)){
         //   word.setStartPoint(i,line.length()-1-line.indexOf(ww));
            word.setStartPoint(line.length()-1-lineRev.indexOf(ww),i);
//            word.setEndPoint(i,line.length()-1-line.indexOf(ww)+ww.length());
            word.setEndPoint(line.length() -lineRev.indexOf(ww)-ww.length(),i);
            //System.out.println(line.length());
            //System.out.println(lineRev.indexOf(ww));
            //System.out.println(ww.length());
            resultList.add(word);
            wordFound=true;
            break;
        }
    }

    if(!wordFound){
        for(int i=0;i<crossword.length;i++){
            for(int y=0;i<crossword.length;i++){
                if (crossword[i][y]==ww.charAt(0)){

                }

            }
        }
    }




}
        return resultList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
/*Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании.


Требования:
1. В классе Solution должен существовать метод detectAllWords.
2. В классе Solution должен существовать класс Word.
3. Метод detectAllWords должен быть статическим.
4. Метод detectAllWords должен быть публичным.
5. Метод detectAllWords должен возвращать список всех слов в кроссворде (согласно условию задачи).*/