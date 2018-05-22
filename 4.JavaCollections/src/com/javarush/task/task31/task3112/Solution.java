package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
/////////////////......работает
/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://utkinzub.ru/wp-content/uploads/2017/08/Aleksandrova-Tatjana-Grigorevna.jpg", Paths.get("c:/Users/mr_ma/Documents/Даша/java/1/"));
//https://utkinzub.ru/wp-content/uploads/2017/08/Aleksandrova-Tatjana-Grigorevna.jpg
     //   https://www.amigo.com/ship/secretPassword.txt
        //c:/Users/mr_ma/Documents/Даша/java/1/
     //   for (String line : Files.readAllLines(passwords)) {
       //     System.out.println(line);
        //}
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();

        Path tempFile = Files.createTempFile("temp-",".tmp");
    //    Files.copy(inputStream, tempFile,StandardCopyOption.REPLACE_EXISTING);
        Files.copy(inputStream, tempFile);
     // Path newFile=  Files.copy(tempFile, downloadDirectory);
        inputStream.close();
     String newFullName= url.getFile();
        String newName= newFullName.substring(newFullName.lastIndexOf("/")+1);
       return   Files.move(tempFile,   downloadDirectory.resolve(Paths.get(newName)));// Files.copy(tempFile,   downloadDirectory.resolve(Paths.get(newName)));




    }
}
/*URL url = new URL("https://www.google.com.ua/images/srpr/logo11w.png");
InputStream inputStream = url.openStream();

Path tempFile = Files.createTempFile("temp-",".tmp");
Files.copy(inputStream, tempFile);
Загрузчик файлов
Реализуй метод downloadFile(String urlString, Path downloadDirectory), на вход которого подается ссылка для скачивания файла и папка, куда нужно закачать файл.
Все ссылки имеют вид:
https://yastatic.net/morda-logo/i/citylogos/yandex19-logo-ru.png
http://toogle.com/files/rules.txt
https://pacemook.com/photos/image1.jpg

Метод должен создать объект URL и загрузить содержимое файла на локальный диск.
Выкачивай сначала во временную директорию, чтобы в случае неуспешной загрузки в твоей директории не оставались недокачанные файлы.
Затем перемести файл в пользовательскую директорию. Имя для файла возьми из ссылки.
Используй только классы и методы из пакета java.nio.


Требования:
1. Метод downloadFile должен создавать объект URL для переданной ссылки.
2. Метод downloadFile должен создать временный файл с помощью метода Files.createTempFile.
3. Метод downloadFile должен скачать файл по ссылке во временный файл, используя метод Files.copy.
4. Метод downloadFile должен переместить файл из временной директории в пользовательскую, используя метод Files.move.
5. Имя сохраненного файла должно быть таким же, как в URL-ссылке.*/