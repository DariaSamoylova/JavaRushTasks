package com.javarush.task.task30.task3008.client;


import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mr_ma on 08.11.2017.
 */
public class BotClient extends  Client{

    protected   SocketThread   getSocketThread(){
        return  new BotSocketThread();
    }

    protected   boolean   shouldSendTextFromConsole(){
        return false;
    }


    protected String getUserName() throws IOException {
        return "date_bot_" + ((int) (Math.random() * 100));
    }

    public   class  BotSocketThread extends  SocketThread{
        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            StringBuilder answer=new StringBuilder();
            SimpleDateFormat s=new SimpleDateFormat();
            if (message.contains(": ")) {
                String name = message.substring(0, message.indexOf(": "));
                answer.append("Информация для ").append(name).append(": ");
                String txt = message.substring(message.indexOf(": ") + 2);
                Date d = Calendar.getInstance().getTime();
                if (txt.equals("дата")) {
                     s = new SimpleDateFormat("d.MM.YYYY");

                } else if (txt.equals("день")) {
                     s = new SimpleDateFormat("d");
                } else if (txt.equals("месяц")) {
                     s = new SimpleDateFormat("MMMM");
                } else if (txt.equals("год")) {
                     s = new SimpleDateFormat("YYYY");
                } else if (txt.equals("время")) {
                     s = new SimpleDateFormat("H:mm:ss");
                } else if (txt.equals("час")) {
                     s = new SimpleDateFormat("H");
                } else if (txt.equals("минуты")) {
                     s = new SimpleDateFormat("m");
                } else if (txt.equals("секунды")) {
                     s = new SimpleDateFormat("s");
                } else return;
                answer.append(s.format(d));
                sendTextMessage(answer.toString());
            }
           // super.processIncomingMessage(message);
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    }

    public  static  void main(String[] args){
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
/*
* Сейчас будем реализовывать класс BotSocketThread, вернее переопределять некоторые его методы, весь основной функционал он уже унаследовал от SocketThread.

1. Переопредели метод clientMainLoop():
а) С помощью метода sendTextMessage() отправь сообщение с текстом «Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.»
б) Вызови реализацию clientMainLoop() родительского класса.
2. Переопредели метод processIncomingMessage(String message). Он должен следующим образом обрабатывать входящие сообщения:
а) Вывести в консоль текст полученного сообщения message.
б) Получить из message имя отправителя и текст сообщения. Они разделены «: «.
в) Отправить ответ в зависимости от текста принятого сообщения.
Если текст сообщения:
«дата» – отправить сообщение содержащее текущую дату в формате «d.MM.YYYY«;
«день» – в формате «d«;
«месяц» — «MMMM«;
«год» — «YYYY«;
«время» — «H:mm:ss«;
«час» — «H«;
«минуты» — «m«;
«секунды» — «s«.
Указанный выше формат используй для создания объекта SimpleDateFormat. Для получения текущей даты необходимо использовать класс Calendar и метод getTime().
Ответ должен содержать имя клиента, который прислал запрос и ожидает ответ, например, если Боб отправил запрос «время«, мы должны отправить ответ «Информация для Боб: 12:30:47«.
Наш бот готов. Запусти сервер, запусти бота, обычного клиента и убедись, что все работает правильно.
Помни, что message бывают разных типов и не всегда содержат «:«


Требования:
1. Метод clientMainLoop класса BotSocketThread должен вызывать метод sendTextMessage у внешнего объекта BotClient c приветственным сообщением указанном в условии задачи.
2. Метод clientMainLoop класса BotSocketThread должен вызывать clientMainLoop у объекта родительского класса (super).
3. Метод processIncomingMessage должен выводить на экран полученное сообщение message.
4. Метод processIncomingMessage должен отправлять ответ с помощью метода sendTextMessage (форматирование согласно условию задачи).
5. Метод processIncomingMessage не должен вызывать метод sendTextMessage для некорректных запросов.
*/