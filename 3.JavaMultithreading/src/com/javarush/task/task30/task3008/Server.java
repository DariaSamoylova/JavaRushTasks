package com.javarush.task.task30.task3008;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mr_ma on 06.11.2017.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ServerSocket s = null;
        try {
            s = new ServerSocket(ConsoleHelper.readInt());
            System.out.println("Сервер запущен");
            while (true) {
                Handler h = new Handler(s.accept());
                h.start();
            }
        } catch (IOException e) {
            try {
                s.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Map.Entry<String, Connection> m : connectionMap.entrySet()) {
                m.getValue().send(message);
            }
        } catch (IOException e) {
            System.out.println("Вы не смогли отправить сообщение");
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }


     /*   private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message mes;
             String name=null;
          //  while (true) {

                try {
                    while (true) {
                        connection.send(new Message(MessageType.NAME_REQUEST));
                        mes = connection.receive();
                        if (mes!=null){// !mes.getData().isEmpty()&&!connectionMap.containsKey( mes.getData())&&mes.getType().equals( MessageType.USER_NAME))
                            MessageType mmm=mes.getType();
                            if (mmm.equals(MessageType.USER_NAME)){
                                name = mes.getData();
                                 if (!name.isEmpty()&&!connectionMap.containsKey( name))
                                        {

                                            connectionMap.put(name, connection);
                                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                                            break;
                                        }
                        }}

                    }

                   // name = mes.getData();
                  //  if (name!=null&&!connectionMap.containsKey(name)) {
                   //     connectionMap.put(name, connection);
                  //  }

                  //  break;
                } catch (Exception e) {

                }

           // }
            return name;
        }*/


        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String name;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST)); //отправляем сообщение
                Message messageReceive = connection.receive();          //Получаем ответ клиента
                if (messageReceive.getType() != MessageType.USER_NAME) continue;
                if (messageReceive.getData().isEmpty()) continue;
                name = messageReceive.getData();
                if (connectionMap.containsKey(name)) continue;
                connectionMap.put(name, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                break;
            }
            return name;
        }


        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> m : connectionMap.entrySet()) {
                String name = m.getKey();
                if (!name.equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, name));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message mes = connection.receive();
                StringBuilder newMes = new StringBuilder();
                //    if (mes.getType().equals(MessageType.TEXT)) {
                if (mes.getType() == MessageType.TEXT) {
                    newMes.append(userName + ": " + mes.getData());
                    sendBroadcastMessage(new Message(MessageType.TEXT, newMes.toString()));
                } else {
                    System.out.println("errrrrror");
                    // break;
                }
            }
        }


        public void run() {
            Connection connection = null;
            String userName = null;

            try {


                System.out.println("Установлено новое соединение с удаленным адресом " + socket.getRemoteSocketAddress());
                connection = new Connection(socket);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
                if (!userName.isEmpty()) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                connection.close();
                System.out.println("Соединение с удаленным адресом закрыто");
            } catch (IOException e) {
                System.out.println("Произошла ошибка при обмене данными с удаленным адресом");
                // try {
                //        connection.close();
                //   } catch (IOException e1) {
                //       e1.printStackTrace();
                //    }

                //  e.printStackTrace();
                // }
            } catch (ClassNotFoundException e) {
                // e.printStackTrace();
                System.out.println("Произошла ошибка при обмене данными с удаленным адресом");
                // try {
                //     connection.close();
                //   } catch (IOException e1) {
                //      e1.printStackTrace();
                //  }
            }
        }

    }
}

/*
Чат (11)
Пришло время написать главный метод класса Handler, который будет вызывать все
вспомогательные методы, написанные ранее. Реализуем метод void run() в классе Handler.

Он должен:
1. Выводить сообщение, что установлено новое соединение с удаленным адресом, который можно получить с помощью метода getRemoteSocketAddress.
2. Создавать Connection, используя поле socket.
3. Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента.
4. Рассылать всем участникам чата информацию об имени присоединившегося участника (сообщение с типом USER_ADDED). Подумай, какой метод подойдет для этого лучше всего.
5. Сообщать новому участнику о существующих участниках.
6. Запускать главный цикл обработки сообщений сервером.
7. Обеспечить закрытие соединения при возникновении исключения.
8. Отловить все исключения типа IOException и ClassNotFoundException, вывести в консоль информацию, что произошла ошибка при обмене данными с удаленным адресом.
9. После того как все исключения обработаны, если п.11.3 отработал и возвратил нам имя, мы должны удалить запись для этого имени из connectionMap и
разослать всем остальным участникам сообщение с типом USER_REMOVED и сохраненным именем.
10. Последнее, что нужно сделать в методе run() – вывести сообщение, информирующее что соединение с удаленным адресом закрыто.

Наш сервер полностью готов. Попробуй его запустить.


Требования:
1. Метод run должен выводить на экран сообщение о том, что было установлено соединение с удаленным адресом (используя метод getRemoteSocketAddress).
2. Метод run должен создавать новое соединение (connection) используя в качестве параметра поле socket.
3. Метод run должен вызывать метод serverHandshake используя в качестве параметра только что созданное соединение; результатом будет имя пользователя (userName).
4. Метод run должен вызывать метод sendBroadcastMessage используя в качестве параметра новое сообщение (MessageType.USER_ADDED, userName).
5. Метод run должен вызывать метод sendListOfUsers используя в качестве параметров connection и userName.
6. Метод run должен вызывать метод serverMainLoop используя в качестве параметров connection и userName.
7. Прежде чем завершиться, метод run должен удалять из connectionMap запись соответствующую userName, и отправлять всем участникам чата сообщение о том, что текущий пользователь был удален.
8. Метод run должен корректно обрабатывать исключения IOException и ClassNotFoundException.
 */