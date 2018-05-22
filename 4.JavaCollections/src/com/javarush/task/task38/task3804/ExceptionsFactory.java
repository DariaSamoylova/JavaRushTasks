package com.javarush.task.task38.task3804;

/**
 * Created by mr_ma on 07.03.2018.
 */
public class ExceptionsFactory {
    public  static Throwable returnEx(Enum e){

        if (e instanceof ExceptionApplicationMessage) {
            String mes=e.name().replaceAll("_"," ");
            mes=mes.substring(0,1)+mes.substring(1).toLowerCase();
            return new Exception(mes);
        } else if (e instanceof ExceptionDBMessage) {
            String mes=e.name().replaceAll("_"," ");
            mes=mes.substring(0,1)+mes.substring(1).toLowerCase();
            return new RuntimeException(mes);
        } else if (e instanceof ExceptionUserMessage) {
            String mes=e.name().replaceAll("_"," ");
            mes=mes.substring(0,1)+mes.substring(1).toLowerCase();
            return new Error(mes);
        } else
            return  new IllegalArgumentException();
            /*  В качестве сообщения (message) для каждого возвращаемого объекта используйте элементы энума, в которых все знаки подчеркивания замените на пробелы.
        Сообщение должно быть в нижнем регистре за исключением первого символа.
        Например, сообщение для ExceptionApplicationMessage.SOCKET_IS_CLOSED - "Socket is closed".

         ExceptionApplicationMessage, верни исключение Exception
        * ExceptionDBMessage, верни исключение RuntimeException
        * ExceptionUserMessage, верни Error иначе верните IllegalArgumentException без сообщения.*/
    }
}
