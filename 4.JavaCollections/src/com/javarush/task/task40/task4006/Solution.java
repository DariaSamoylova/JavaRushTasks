package com.javarush.task.task40.task4006;

import java.io.*;

import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));

    }

    public static void getSite(URL url) {
        try {
            Socket socket = new Socket(url.getHost(),80);
            OutputStream out =  socket.getOutputStream();

            String request = "GET "+url.getFile()+" HTTP/1.1\r\n";
            request +="Host: "+url.getHost()+"\r\n\r\n";

            out.write(request.getBytes());
            out.flush();



            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String responseLine;

            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
            bufferedReader.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*Отправка GET-запроса через сокет
Перепиши реализацию метода getSite, он должен явно создавать и использовать сокетное соединение Socket с сервером.
Адрес сервера и параметры для GET-запроса получи из параметра url.
Порт используй дефолтный для http (80).
Классы HttpURLConnection, HttpClient и т.д. не использовать.
Не оставляй закомементированный код.

 //getSite(new URL( "http://fitstudio.xfit.ru/"));
Требования:
1. Метод getSite должен создавать объект класса Socket с правильными параметрами (String host, int port).
2. Метод getSite должен записать в OutputStream правильный запрос.
3. Метод getSite должен выводить на экран InputStream сокета.
4. Метод getSite не должен использовать HttpURLConnection или HttpClient.*/