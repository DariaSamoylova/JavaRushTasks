package com.javarush.task.task14.task1419;

import javax.naming.directory.NoSuchAttributeException;
import javax.security.auth.login.AccountException;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.reflect.Method;
import java.nio.file.FileAlreadyExistsException;
import java.rmi.NotBoundException;
import java.rmi.activation.ActivateFailedException;
import java.util.ArrayList;
import java.util.List;
import java.util.UnknownFormatConversionException;
import java.util.concurrent.BrokenBarrierException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;


        } catch (ArithmeticException e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

try {
    throw new ArrayStoreException();
} catch (ArrayStoreException e) {
    exceptions.add(e);
}

        try {
            throw new Exception();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            throw new StringIndexOutOfBoundsException();
        } catch (StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            throw new NegativeArraySizeException();
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }

        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            exceptions.add(e);
        }

        try {
            throw new NumberFormatException();
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }

        try {
            throw new TypeNotPresentException("f",new Throwable());
        } catch (TypeNotPresentException e) {
            exceptions.add(e);
        }

        try {
            throw new UnknownFormatConversionException("l");
        } catch (UnknownFormatConversionException e) {
            exceptions.add(e);
        }


    }
}
/*Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.


Требования:
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.*/