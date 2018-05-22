package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by mr_ma on 21.12.2017.
 */
public class CustomInvocationHandler implements InvocationHandler {
    SomeInterfaceWithMethods target;

    public CustomInvocationHandler(SomeInterfaceWithMethods target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+" in");
        Object result = method.invoke(target,args);
        System.out.println(method.getName()+" out");
        return result;
    }
}
/*1) В отдельном файле создай публичный класс CustomInvocationHandler, который будет хэндлером при создании прокси-объекта.
2) CustomInvocationHandler должен поддерживать интерфейс InvocationHandler.
3) CustomInvocationHandler должен иметь один публичный конструктор с одним аргументом типа SomeInterfaceWithMethods.
4) Перед вызовом любого метода у оригинального объекта должна выводиться фраза [methodName in].
5) После вызова любого метода у оригинального объекта должна выводиться фраза [methodName out].
6) Реализуй логику метода getProxy, который должен создавать прокси (Proxy.newProxyInstance(...)).
См. пример вывода в методе main.
Метод main не участвует в тестировании.4) Перед вызовом любого метода у оригинального объекта должна выводиться фраза [methodName in].
5) После вызова любого метода у оригинального объекта должна выводиться фраза [methodName out].
6) Реализуй логику метода getProxy, который должен создавать прокси (Proxy.newProxyInstance(...)).*/