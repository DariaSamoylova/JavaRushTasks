package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public static void main(String[] args) {

    }

    public FileConsoleWriter(File file)  {
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   // Constructs a FileWriter object given a File object.
    public  FileConsoleWriter(File file, boolean append){
        try {
            fileWriter = new FileWriter(file,append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  //  Constructs a FileWriter object given a File object.
    public   FileConsoleWriter(FileDescriptor fd){
        fileWriter = new FileWriter(fd);
    }
   // Constructs a FileWriter object associated with a file descriptor.
    public  FileConsoleWriter(String fileName){
        try {
            fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   // Constructs a FileWriter object given a file name.
    public  FileConsoleWriter(String fileName, boolean append){
        try {
            fileWriter = new FileWriter(fileName,append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   // Constructs a FileWriter object given a file name with a boolean indicating whether or not to append the data written.


    public void write(char[] cbuf, int off, int len) throws IOException{
        fileWriter.write(cbuf, off, len);
        System.out.print(new String(cbuf, off, len));
    //   String g = cbuf.toString();
        // for(int i=off;i<len;i++) {
         //    System.out.print(g.substring(off,off+len));
        // }
    }
    public void write(int c) throws IOException{
        fileWriter.write(c);
        System.out.print(c);
    }
    public void write(String str) throws IOException{
        fileWriter.write(str);
        System.out.print(str);
    }
    public void write(String str, int off, int len){
        try {
            fileWriter.write(str, off, len);
            System.out.print(str.substring(off,off+len));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void write(char[] cbuf) throws IOException{
        fileWriter.write(cbuf);
        for(int i=0;i<cbuf.length;i++) {
            System.out.print(cbuf[i]);
        }
    }
    public void close() throws IOException{
        fileWriter.close();
    }

}
/*Свой FileWriter
Реализовать логику FileConsoleWriter.
Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter.
Класс FileConsoleWriter должен содержать все конструкторы, которые инициализируют fileWriter для записи.
Класс FileConsoleWriter должен содержать пять методов write и один метод close:

public void write(char[] cbuf, int off, int len) throws IOException
public void write(int c) throws IOException
public void write(String str) throws IOException
public void write(String str, int off, int len)
public void write(char[] cbuf) throws IOException
public void close() throws IOException
При записи данных в файл, должен дублировать эти данные на консоль.


Требования:
1. Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter, которое не должно быть сразу проинициализировано.
2. Класс FileConsoleWriter должен иметь пять конструкторов которые инициализируют fileWriter для записи.
3. Класс FileConsoleWriter должен содержать метод write(char[] cbuf, int off, int len) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
4. Класс FileConsoleWriter должен содержать метод write(int c) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
5. Класс FileConsoleWriter должен содержать метод write(String str) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
6. Класс FileConsoleWriter должен содержать метод write(String str, int off, int len) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
7. Класс FileConsoleWriter должен содержать метод write(char[] cbuf) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
8. Класс FileConsoleWriter должен содержать метод close() throws IOException, в котором должен вызываться такой же метод поля fileWriter.*/