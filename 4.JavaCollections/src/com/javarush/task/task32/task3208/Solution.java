package com.javarush.task.task32.task3208;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI-2
*/
public class Solution {
    public static Registry registry;

    //pretend we start rmi client as CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
             //   registry = LocateRegistry.createRegistry(2099);
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.say();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    //pretend we start rmi server as SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        public static final String UNIC_BINDING_NAME_DOG = "animal.dog";
        public static final String UNIC_BINDING_NAME_CAT = "animal.cat";
        @Override
        public void run() {
            //напишите тут ваш код

            Remote stubDog = null;
            Remote stubCat = null;
            try {
                registry = LocateRegistry.createRegistry(2099);
                //  final DoubleStringImpl service = new DoubleStringImpl();
                Dog dog = new Dog("dog");
                Cat cat = new Cat(("cat"));
                stubDog = UnicastRemoteObject.exportObject(dog, 2099);
                stubCat = UnicastRemoteObject.exportObject(cat, 2099);
                registry.bind(UNIC_BINDING_NAME_DOG, stubDog);
                registry.bind(UNIC_BINDING_NAME_CAT, stubCat);
                //   } catch (RemoteException e) {
                //      e.printStackTrace();
                //  } catch (AlreadyBoundException e) {
                //      e.printStackTrace();
                // }
                //   } catch (Exception e){
                //      e.printStackTrace();
                //   }
            }     catch (RemoteException | AlreadyBoundException e) { e.printStackTrace(System.err); }

            }
    });

    public static void main(String[] args) throws InterruptedException {
        //start rmi server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        //start client
        CLIENT_THREAD.start();
    }

}
/*RMI-2
Реализуй логику метода run в SERVER_THREAD. В нем будет имитироваться серверная часть:
1) Инициализируй поле registry, которое будет принимать и обрабатывать запросы на 2099 порту.
2) Создай два объекта - Cat и Dog.
3) Используй класс UnicastRemoteObject, чтобы создать Remote объекты для созданных Cat и Dog.
Remote объекты будут в состоянии принимать обращения к своим методам используя выбранный порт (2099).
4) Для Cat и Dog добавь в registry связь уникального текстового ключа и Remote объекта. Текстовый ключ придумай сам.
5) При возникновении любого исключения выведи его стек-трейс в поток System.err.
Метод main не участвует в тестировании.


Требования:
1. В методе run() необходимо инициализировать поле registry. Для этого используй LocateRegistry.createRegistry (2099).
2. В методе run() необходимо создать два объекта - Cat и Dog.
3. В методе run() необходимо создать Remote объекты для созданных Cat и Dog используя UnicastRemoteObject.exportObject (Remote, int).
4. Для Cat и Dog нужно добавить в registry связь уникального текстового ключа и Remote объекта используя registry.bind (String, Remote).
5. При возникновении любого исключения нужно вывести его стек-трейс в поток System.err используя метод printStackTrace ().*/