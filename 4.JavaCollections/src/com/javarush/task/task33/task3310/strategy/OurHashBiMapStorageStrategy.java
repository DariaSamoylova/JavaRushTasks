package com.javarush.task.task33.task3310.strategy;

import com.google.common.collect.HashBiMap;

import java.util.HashMap;

/**
 * Created by mr_ma on 22.02.2018.
 */
public class OurHashBiMapStorageStrategy implements  StorageStrategy {
    private  HashMap<Long, String> k2v= new HashMap<>() ;
    private HashMap<String, Long> v2k= new HashMap<>();

    @Override
    public boolean containsKey(Long key) {
        return k2v.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return v2k.containsKey(value);
    }

    @Override
    public void put(Long key, String value) {
        k2v.put(key, value);
        v2k.put(value, key);
    }

    @Override
    public Long getKey(String value) {
        return v2k.get(value);
    }

    @Override
    public String getValue(Long key) {
        return k2v.get(key);
    }
    /* public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
      for(Map.Entry<Long, String> mmm:data.entrySet()){
          if (mmm.getValue().equals(value))
              return mmm.getKey();
      }
      return null;
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }*/
}
