package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootDir = new File(root);
        List<String> result = new ArrayList<>();
        Queue<File> fileTree = new PriorityQueue<>();

        Collections.addAll(fileTree, rootDir.listFiles());

        while (!fileTree.isEmpty())
        {
            File currentFile = fileTree.remove();
            if(currentFile.isDirectory()){
                Collections.addAll(fileTree, currentFile.listFiles());
            } else {
                result.add(currentFile.getAbsolutePath());
            }
        }
return  result;
    }

    public static void main(String[] args) throws IOException {
        List<String> t=  getFileTree("c:\\Users\\mr_ma\\Documents\\Даша\\java\\1");
        for(String s:t){
            System.out.println(s);
        }
    }
}


/*Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
        Используй очередь, рекурсию не используй.
        Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
        Путь должен быть абсолютный.


        Требования:
        1. Метод getFileTree должен принимать аргументом String root, по которому нужно найти все вложенные файлы.
        2. Метод getFileTree должен возвращать список строк.
        3. Нужно реализовать метод getFileTree: найти все файлы по указанному пути и добавить их в список.
        4. Метод getFileTree должен быть вызван только 1 раз (рекурсию не использовать).


        File rootDir = new File(root);
List<String> result = new ArrayList<>();
Queue<File> fileTree = new PriorityQueue<>();

Collections.addAll(fileTree, rootDir.listFiles());

while (!fileTree.isEmpty())
{
    File currentFile = fileTree.remove();
    if(currentFile.isDirectory()){
        Collections.addAll(fileTree, currentFile.listFiles());
    } else {
        result.add(currentFile.getAbsolutePath());
    }
}
        */