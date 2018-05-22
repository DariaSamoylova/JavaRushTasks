package com.javarush.task.task38.task3810;

import java.lang.annotation.Inherited;

@Inherited
public @interface Date   {
    //напиши свой код

   int year();
   int  month();
   int  day();
   int  hour();
   int  minute();
   int  second();
}
