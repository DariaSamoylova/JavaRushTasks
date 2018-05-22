package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Проход по дереву файлов
*/
/*
public class Solution {
    public static void main(String[] args) throws IOException {
    //    File path=new File("c:\\Users\\mr_ma\\Documents\\Даша\\java\\1\\ext\\");//new File(args[0]);
//        File resultFileAbsolutePath=new File("c:\\Users\\mr_ma\\Documents\\Даша\\java\\1\\4.txt");//new File(args[1]);
        File path=new File(args[0]);
        File resultFileAbsolutePath=new File(args[1]);
        HashMap<File,String> listFiles  = new HashMap<>();

        ArrayList<String> listFilesNames = new ArrayList<>();
        for(File f: path.listFiles()){
if (f.length()>50){
    FileUtils.deleteFile(f);
} else {
    listFiles.put(f,f.getName());
    listFilesNames.add(f.getName());
}

        }


        HashMap<File,String> sortListFiles  = sortByValue(listFiles);
        String wholePath=resultFileAbsolutePath.getPath();
        String newPath=wholePath.substring(0,wholePath.lastIndexOf("\\")+1)+"allFilesContent.txt";
        File allFilesContent = new File(newPath);
        if(! FileUtils.isExist(allFilesContent) ){
            FileUtils.renameFile(resultFileAbsolutePath,allFilesContent);
        }
        FileOutputStream out = new FileOutputStream(allFilesContent);

        for(Map.Entry<File,String> entry:sortListFiles.entrySet()){

            FileInputStream in = new FileInputStream(entry.getKey());
           while(in.available()>0){
               out.write(in.read());
           }

            out.write((byte) '\n');
           in.close();
        }
        out.close();
    }

    public static <K, V extends Comparable<? super V>> HashMap<K, V> sortByValue(HashMap<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())//(Collections.reverseOrder())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}


*/

public class Solution {
    private static ArrayList<File> fileList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        try (FileOutputStream fileOutputStream = new FileOutputStream(allFilesContent)) {

            fillFileList(path.getPath());
            fileList.sort(new FileNameComparator());

            for (File file : fileList) {
                FileInputStream fileInputStream = new FileInputStream(file);
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read());
                }
                fileOutputStream.write(System.lineSeparator().getBytes());
                fileOutputStream.flush();

                fileInputStream.close();
            }
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }


    //Рекурсивно пробегаем поддиректории и заполняем список файлов
    private static void fillFileList(String path) {
        File[] files = new File(path).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                fillFileList(file.getAbsolutePath());
                continue;
            }
            if (file.length() > 50)
                FileUtils.deleteFile(file);
            else
                fileList.add(file);
        }
    }
}

//Компаратор для сравнения
class FileNameComparator implements Comparator<File> {
    public int compare(File first, File second) {
        return first.getName().compareTo(second.getName());
    }
}


/*Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя существующего файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его (используй метод FileUtils.deleteFile).
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
2.2.2. Переименовать resultFileAbsolutePath в 'allFilesContent.txt' (используй метод FileUtils.renameFile, и, если понадобится, FileUtils.isExist).
2.2.3. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. После каждого тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".


Требования:
1. Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
2. Нужно создать поток для записи в переименованный файл.
3. Пройдись по всем файлам в директории, которая приходит первым параметром в main, и всех ее поддиректориях. Файлы с размером более 50 байт нужно удалить используя метод FileUtils.deleteFile.
4. Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt в отсортированном по имени файла порядке.
5. Поток для записи в файл нужно закрыть.*/