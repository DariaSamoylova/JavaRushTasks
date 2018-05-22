package com.javarush.task.task32.task3207;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
К серверу по RMI
*/
public class Solution {
    public static final String UNIC_BINDING_NAME = "double.string";
    public static Registry registry;

    //pretend we start rmi client as CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //напишите тут ваш код


            //получаем объект (на самом деле это proxy-объект)

            try {
              //  registry = LocateRegistry.createRegistry(2099);
                DoubleString service = (DoubleString) registry.lookup(UNIC_BINDING_NAME);

                System.out.println(service.doubleString("w"));
            } catch (NotBoundException e) {

            } catch (RemoteException e) {

            //} catch (Exception e) {

            }
        }}
    );

    public static void main(String[] args) {
        //pretend we start rmi server as main thread
        Remote stub = null;
        try {
            registry = LocateRegistry.createRegistry(2099);
            final DoubleStringImpl service = new DoubleStringImpl();

            stub = UnicastRemoteObject.exportObject(service, 0);
            registry.bind(UNIC_BINDING_NAME, stub);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

        //start client
        CLIENT_THREAD.start();
    }
}
/*public static final String UNIC_BINDING_NAME = "server.reverse";

public static void main(String[] args) throws Exception
{
 //создание объекта для удаленного доступа
 final ReverseImpl service = new ReverseImpl();

 //создание реестра расшареных объетов
 final Registry registry = LocateRegistry.createRegistry(2099);
 //создание "заглушки" – приемника удаленных вызовов
 Remote stub = UnicastRemoteObject.exportObject(service, 0);
 //регистрация "заглушки" в реесте
 registry.bind(UNIC_BINDING_NAME, stub);

 //усыпляем главный поток, иначе программа завершится
 Thread.sleep(Integer.MAX_VALUE);
}
------------
%public static final String UNIC_BINDING_NAME = "server.reverse";

public static void main(String[] args) throws Exception
{
 //создание реестра расшареных объетов
 final Registry registry = LocateRegistry.createRegistry(2099);

 //получаем объект (на самом деле это proxy-объект)
 Reverse service = (Reverse) registry.lookup(UNIC_BINDING_NAME);

 //Вызываем удаленный метод
 String result = service.reverse("Home sweet home.");
}
К серверу по RMI
Реализуй логику метода run в CLIENT_THREAD. В нем будет имитироваться клиентская часть, которая коннектится к серверу.
1) Из registry получи сервис с именем UNIC_BINDING_NAME.
2) Вызови метод у полученного сервиса, передай любой не пустой аргумент.
3) Выведи в консоль результат вызова метода.
4) Обработай специфические исключения.
Метод main не участвует в тестировании.


Требования:
1. В методе run() необходимо из registry получить сервис с именем UNIC_BINDING_NAME.
2. В методе run() необходимо вызвать метод doubleString (String) у полученного сервиса.
3. В методе run() необходимо вывести в консоль результат вызова метода doubleString (String).
4. В методе run() должен быть перехват исключения RemoteException.
5. В методе run() должен быть перехват исключения NotBoundException.*/