package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

/**
 * Created by mr_ma on 02.02.2018.
 */
public class FactoryProducer {
    public static enum HumanFactoryType{MALE, FEMALE};
    public  static AbstractFactory getFactory(HumanFactoryType hft){
        if (hft.name().equals("MALE")){
            return new MaleFactory();
        } else   if (hft.name().equals("FEMALE"))   {
            return new FemaleFactory();
        } else return null;
    }
}
/* публичный статический энум HumanFactoryType со значениями MALE, FEMALE.

4. В FactoryProducer создай публичный статический метод getFactory с аргументом HumanFactoryType.
Этот метод должен возвращать одну из фабрик: для ключа MALE - MaleFactory, для FEMALE - FemaleFactory.*/