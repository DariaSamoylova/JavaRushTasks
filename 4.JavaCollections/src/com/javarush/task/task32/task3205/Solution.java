package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/*
Создание прокси-объекта
*/
public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {
     //   SomeInterfaceWithMethodsImpl t = new SomeInterfaceWithMethodsImpl();
        ClassLoader classLoader = SomeInterfaceWithMethods.class.getClassLoader();
        Class[] classes = new Class[]{SomeInterfaceWithMethods.class};
        InvocationHandler hnd = new CustomInvocationHandler(new SomeInterfaceWithMethodsImpl());

        return  (SomeInterfaceWithMethods)(Proxy.newProxyInstance(classLoader,classes,hnd));
    }
}

/*В методе getProxy при вызове метода newProxyInstance нужно использовать такие аргументы: ClassLoader - класслоадер объекта SomeInterfaceWithMethods;
 Class[] - массив на один элемент, который содержит класс SomeInterfaceWithMethods; InvocationHandler - объект типа CustomInvocationHandler.
Создание прокси-объекта
1) В отдельном файле создай публичный класс CustomInvocationHandler, который будет хэндлером при создании прокси-объекта.
2) CustomInvocationHandler должен поддерживать интерфейс InvocationHandler.
3) CustomInvocationHandler должен иметь один публичный конструктор с одним аргументом типа SomeInterfaceWithMethods.
4) Перед вызовом любого метода у оригинального объекта должна выводиться фраза [methodName in].
5) После вызова любого метода у оригинального объекта должна выводиться фраза [methodName out].
6) Реализуй логику метода getProxy, который должен создавать прокси (Proxy.newProxyInstance(...)).
См. пример вывода в методе main.
Метод main не участвует в тестировании.


Требования:
1. Класс CustomInvocationHandler должен существовать.
2. Класс CustomInvocationHandler должен поддерживать интерфейс InvocationHandler.
3. Класс CustomInvocationHandler должен иметь один публичный конструктор с одним аргументом типа SomeInterfaceWithMethods.
4. Перед вызовом любого метода у оригинального объекта должна выводиться фраза [methodName in].
5. После вызова любого метода у оригинального объекта должна выводиться фраза [methodName out].
6. Метод getProxy должен создавать прокси для интерфейса SomeInterfaceWithMethods.*/