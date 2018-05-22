package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
*/
public class Solution {
    public static void main(String[] args) {
        int modifiersOfThisClass = Solution.class.getModifiers();
      //  System.out.println("1="+modifiersOfThisClass);
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false

        int modifiersOfMethod = getMainMethod().getModifiers();
     //   System.out.println("2="+Modifier.isStatic(modifiersOfMethod));
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
        if((specificModifier==Modifier.STATIC)&&(Modifier.isStatic(allModifiers)))
            return true;
        if((specificModifier==Modifier.PUBLIC)&&(Modifier.isPublic(allModifiers)))
            return true;
      //  if((specificModifier==Modifier.STATIC)&&(Modifier.isStatic(allModifiers)))
        //    return true;
        return false;
    }
/*public static final int	ABSTRACT	1024
public static final int	FINAL	16
public static final int	INTERFACE	512
public static final int	NATIVE	256
public static final int	PRIVATE	2
public static final int	PROTECTED	4
public static final int	PUBLIC	1
public static final int	STATIC	8
public static final int	STRICT	2048
public static final int	SYNCHRONIZED	32
public static final int	TRANSIENT	128
public static final int	VOLATILE	64*/
    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }

  /*  abstract class S{

    }*/
}
/*Сравниваем модификаторы
Реализовать логику метода isAllModifiersContainSpecificModifier, который проверяет, содержит ли переданный параметр allModifiers значение конкретного модификатора specificModifier.

P.S. Перед выполнением задания ознакомься с классом Modifier и реализацией методов isPublic, isStatic и т.п.


Требования:
1. Метод isAllModifiersContainSpecificModifier должен быть статическим.
2. Метод isAllModifiersContainSpecificModifier должен возвращать значение типа boolean.
3. Метод isAllModifiersContainSpecificModifier должен принимать два параметра типа int.
4. Метод isAllModifiersContainSpecificModifier должен возвращать корректное значение в соответствии с условием задачи(true, если заданный модификатор присутствует в allModifiers, иначе false).*/