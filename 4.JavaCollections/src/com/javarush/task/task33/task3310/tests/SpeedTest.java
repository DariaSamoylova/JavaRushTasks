package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mr_ma on 24.02.2018.
 */
public class SpeedTest {
    public  long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Long start = new Date().getTime();

        for(String g:strings){
            ids.add(shortener.getId(g));
        }
   Long end = new Date().getTime();
      return  end-start;
    }


    public  long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Long start = new Date().getTime();

        for(Long g:ids){
            strings.add(shortener.getString(g));
        }
        Long end = new Date().getTime();
        return  end-start;
    }

    @Test
   public void testHashMapStorage(){
       Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
       Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
Set<String> origStrings = new HashSet<>();
       for (long i=0L;i<10000;i++) {
           origStrings.add(Helper.generateRandomString());
       }

      Long time1= getTimeForGettingIds(shortener1,origStrings,new HashSet<>());
        Long time2=       getTimeForGettingIds(shortener2,origStrings,new HashSet<>());
        Assert.assertTrue(time1 > time2);

      /*  Set<Long> origIds1 = new HashSet<>();
        Set<Long> origIds2 = new HashSet<>();

         for(String g:origStrings){
            origIds1.add(shortener1.getId(g));
        }
        for(String g:origStrings){
            origIds2.add(shortener2.getId(g));
        }
        Long time11= getTimeForGettingStrings(shortener1, origIds1,new HashSet<>());
        Long time22=       getTimeForGettingStrings(shortener2,  origIds2,new HashSet<>());*/
        Long time11= getTimeForGettingStrings(shortener1, new HashSet<>(),new HashSet<>());
        Long time22=       getTimeForGettingStrings(shortener2,  new HashSet<>(),new HashSet<>());
        Assert.assertEquals(time11,time22,30);
    }
}
/*15.1. Создай класс SpeedTest в пакете tests.
        15.2. Добавь в класс метод long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids).
         Он должен возвращать время в миллисекундах необходимое для получения идентификаторов для всех строк из strings. Идентификаторы должны быть записаны в ids.
        15.3. Добавь в класс метод long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings).
        Он должен возвращать время в миллисекундах необходимое для получения строк для всех строк из ids. Строки должны быть записаны в strings.
        15.4. Добавь в класс SpeedTest тест testHashMapStorage(). Он должен:
        15.4.1. Создавать два объекта типа Shortener, один на базе HashMapStorageStrategy, второй на базе HashBiMapStorageStrategy. Назовем их shortener1 и shortener2.
        15.4.2. Генерировать с помощью Helper 10000 строк и помещать их в сет со строками, назовем его origStrings.
        15.4.3. Получать время получения идентификаторов для origStrings (вызывать метод getTimeForGettingIds для shortener1, а затем для shortener2).
        15.4.4. Проверять с помощью junit, что время, полученное в предыдущем пункте для shortener1 больше, чем для shortener2.
        15.4.5. Получать время получения строк (вызывать метод getTimeForGettingStrings для shortener1 и shortener2).

        15.4.6. Проверять с помощью junit, что время, полученное в предыдущем пункте для shortener1 примерно равно времени для shortener2.
        Используй метод assertEquals(float expected, float actual, float delta). В качестве delta можно использовать 30, этого вполне достаточно для наших экспериментов.


        Требования:
        1. Метод getTimeForGettingStrings должен возвращать время в миллисекундах необходимое для получения всех строк для множества идентификаторов ids.
        2. Метод getTimeForGettingIds должен возвращать время в миллисекундах необходимое для получения всех идентификаторов для множества строк strings.
        3. В методе testHashMapStorage должно быть выполнено сравнение времени получения множества ключей и множества значений для стратегий HashMapStorageStrategy и HashBiMapStorageStrategy.*/