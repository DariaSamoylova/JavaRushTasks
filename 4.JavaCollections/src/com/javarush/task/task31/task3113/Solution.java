package com.javarush.task.task31.task3113;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


/* 
Что внутри папки?
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/*
Что внутри папки?
*/
public class Solution {

    private static int filesCount;
    private static int dirsCount;
    private static long filesTotalSize;

    public static void main(String[] args) throws IOException {

        BufferedReader cbr = new BufferedReader(new InputStreamReader(System.in));

        Path path = Paths.get(cbr.readLine());

        if (Files.isDirectory(path)) {

            filesCount = dirsCount = 0;
            filesTotalSize = 0;

            int depth = path.getNameCount() + 1;

            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    filesCount++;
                    filesTotalSize += Files.size(file);
                    return super.visitFile(file, attrs);
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (!dir.equals(path)) {
                        dirsCount++;
                    }
                    return super.postVisitDirectory(dir, exc);
                }
            });

            System.out.println("Всего папок - " + dirsCount);
            System.out.println("Всего файлов - " + filesCount);
            System.out.println("Общий размер - " + filesTotalSize);

        } else {
            System.out.println(path.toAbsolutePath() + " - не папка");
        }


    }
}
/*
Мой код::

public class Solution   {
private static int countDir;
    private static int countFiles;
    private static int countBytes;

    public static void main(String[] args) throws IOException {
       BufferedReader r = new BufferedReader(  new InputStreamReader(System.in));
       String pathString = r.readLine();
       r.close();
       File pathFile = new File(pathString);
       Path pathPath = Paths.get(pathString);
       if (!pathFile.isDirectory()) {
           System.out.println(pathString+" - не папка");
           return;
       }

        Files.walkFileTree(pathPath,new SimpleFileVisitor<Path>(){
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {


                countFiles++;
                countBytes=countBytes+Files.readAllBytes(file).length;

                return super.visitFile(file, attrs);
            }

            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                countDir++;
                return super.postVisitDirectory(dir, exc);
            }
        });
        System.out.println("Всего папок - "+(countDir-1));
        System.out.println("Всего файлов - "+countFiles);
        System.out.println("Общий размер - "+countBytes);
    }




}
 !!!!!!!!!!!!!!!!Исключение системы безопасности JavaRush. Вы выполняете потенциально опасную или запрещенную операцию.
 */