package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mr_ma on 24.02.2018.
 */
public class FunctionalTest {
  public  void   testStorage(Shortener shortener){
      String stroka1="stroka";
      String stroka2="qqq";
      String stroka3="stroka";

      Long id1=shortener.getId(stroka1);
      Long id2=shortener.getId(stroka2);
      Long id3=shortener.getId(stroka3);


      Assert.assertNotEquals(id1,id2);
      Assert.assertNotEquals(id3,id2);
      Assert.assertEquals(id1,id3);
      String testString1=shortener.getString(id1);
      String testString2=shortener.getString(id2);
      String testString3=shortener.getString(id3);
      Assert.assertEquals(stroka1,testString1);
      Assert.assertEquals(stroka2,testString2);
      Assert.assertEquals(stroka3,testString3);
    }


    @Test
    public  void   testHashMapStorageStrategy(){
        HashMapStorageStrategy strategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public  void   testOurHashMapStorageStrategy(){
        OurHashMapStorageStrategy strategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public  void   testFileStorageStrategy(){
        FileStorageStrategy strategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(strategy);
    
        testStorage(shortener);
    }

    @Test
    public  void   testHashBiMapStorageStrategy(){
        HashBiMapStorageStrategy strategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public  void   testDualHashBidiMapStorageStrategy(){
        DualHashBidiMapStorageStrategy strategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public  void   testOurHashBiMapStorageStrategy(){
        OurHashBiMapStorageStrategy strategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
}
