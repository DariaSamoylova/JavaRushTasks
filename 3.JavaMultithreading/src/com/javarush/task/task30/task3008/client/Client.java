package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by mr_ma on 07.11.2017.
 */
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() throws IOException {
        //  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        return ConsoleHelper.readString();

    }

    protected int getServerPort() throws IOException {
        //  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        return ConsoleHelper.readInt();
    }

    protected String getUserName() throws IOException {
        //BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("error");
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread newThr = getSocketThread();
        newThr.setDaemon(true);
        newThr.start();
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // e.printStackTrace();
                System.out.println("error wait newThr_Client");
            }
        }
        if (clientConnected){
            System.out.println("Соединение установлено.Для выхода наберите команду ‘exit’.");
        } else {
            System.out.println("Произошла ошибка во время работы клиента.");
        }
        while(clientConnected) {
            String txt= ConsoleHelper.readString();
          if ( txt.equals("exit")) break;
          if (shouldSendTextFromConsole()){
              sendTextMessage(txt);
          }
        }
    }

    public class SocketThread extends Thread {
     protected   void processIncomingMessage(String message){
         ConsoleHelper.writeMessage(message);
     }
        protected   void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage("Участник с именем "+userName+" присоединился к чату.");
        }

        protected   void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage("Участник с именем "+userName+" покинул чат.");
        }

        protected   void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected=clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while(true){
               Message mes= connection.receive();
                MessageType mesT=mes.getType();
             //  if (mesT.equals(MessageType.NAME_REQUEST)){
                if (mesT==MessageType.NAME_REQUEST){
                  String name= getUserName();
                  connection.send(new Message(MessageType.USER_NAME,name));
                 // break;
               }
            //   else if (mesT.equals(MessageType.NAME_ACCEPTED)){
                else if (mesT==MessageType.NAME_ACCEPTED){
                 //   String name= getUserName();
                  //  connection.send(new Message(MessageType.USER_NAME,name));
                    notifyConnectionStatusChanged(true);
                   break;
                } else {
                   throw new IOException("Unexpected MessageType");

               }
            }
        }

        protected  void clientMainLoop() throws IOException, ClassNotFoundException{
            while(true){
                Message mes= connection.receive();
                MessageType mesT=mes.getType();
               // if (mesT.equals(MessageType.TEXT)){
                if (mesT==MessageType.TEXT){
                    processIncomingMessage(mes.getData());

                 //   break;
              //  }else  if (mesT.equals(MessageType.USER_ADDED)){
                }else  if (mesT==MessageType.USER_ADDED){
                    informAboutAddingNewUser(mes.getData());
              //  }else  if (mesT.equals(MessageType.USER_REMOVED)){
                }else  if (mesT==MessageType.USER_REMOVED){
                informAboutDeletingNewUser(mes.getData());
            }else {
                    throw new IOException("Unexpected MessageType");

                }
            }
        }

        @Override
        public void run() {
            try {
              String addr=  getServerAddress();
              int port=  getServerPort();
                Socket newSocket = new Socket(addr,port);
             connection = new Connection(newSocket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException e) {
              //  e.printStackTrace();
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException e) {
               // e.printStackTrace();
                notifyConnectionStatusChanged(false);
            }

        }
    }

    public  static  void main(String[] args){
        Client client = new Client();
        client.run();
    }
}
/*Чат (17)
Последний, но самый главный метод класса SocketThread – это метод void run(). Добавь его. Его реализация с учетом уже созданных методов выглядит очень просто.
В методе run должно быть установлено и сохранено в поле connection соединение с сервером (для получения адреса сервера и порта используй методы getServerAddress и getServerPort).
Давай напишем ее:
1) Запроси адрес и порт сервера с помощью методов getServerAddress() и getServerPort().
2) Создай новый объект класса java.net.Socket, используя данные, полученные в предыдущем пункте.
3) Создай объект класса Connection, используя сокет из п.17.2.
4) Вызови метод, реализующий «рукопожатие» клиента с сервером (clientHandshake()).
5) Вызови метод, реализующий основной цикл обработки сообщений сервера.
6) При возникновении исключений IOException или ClassNotFoundException сообщи главному потоку о проблеме, используя notifyConnectionStatusChanged и false в качестве параметра.

Клиент готов, можешь запустить сервер, несколько клиентов и проверить как все работает.


Требования:
1. В методе run должно быть установлено и сохранено в поле connection соединение с сервером (для получения адреса сервера и порта используй методы getServerAddress и getServerPort).
2. В методе run должен быть вызван метод clientHandshake.
3. В методе run должен быть вызван метод clientMainLoop.
4. При возникновении исключений IOException или ClassNotFoundException в процессе работы метода run, должен быть вызван метод notifyConnectionStatusChanged с параметром false.
5. Сигнатура метода run должна соответствовать условию задачи.

*/