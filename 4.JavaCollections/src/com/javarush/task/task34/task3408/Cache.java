package com.javarush.task.task34.task3408;

import sun.reflect.Reflection;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;


public class Cache<K, V> {
    private Map<K, V> cache =new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if (!cache.containsKey(key))
            cache.put(key, clazz.getConstructor(key.getClass()).newInstance(key));

        return cache.get(key);/*
        V res = cache.get(key);
        if (res == null){
            res =(V) clazz.newInstance();

            this.put(res);
           // cache.put(key,res);
           // res = cache.get(key);
             // System.out.println("key="+key);
    }
        //TODO add your code here
        return res;*/
    }

    public boolean put(V obj)   {
        //TODO add your code here
      try {
        //  System.out.println("obj.getClass()="+obj.getClass());
        //  obj.getClass().getMethods()..setAccessible(true);
          Method method = obj.getClass().getDeclaredMethod("getKey");

          method.setAccessible(true);
        //  System.out.println("meth="+method);
          K key = (K) method.invoke(obj);
          cache.put(key, obj);
          return true;
      } catch (Exception e){
        //  System.out.println(e);
          return false;
      }
    }

    public int size() {
        return cache.size();
    }
}
/*Кэширование
Класс Cache - универсальный параметризированный класс для кеширования объектов.
Он работает с классами (дженерик тип Т), у которых обязан быть:
а) публичный конструктор с одним параметром типа K;
б) метод K getKey() с любым модификатором доступа.

Задание:
1. Выбери правильный тип для поля cache. Map<K, V> cache должен хранить ключи, на которые есть активные ссылки.
Если нет активных ссылок на ключи, то они вместе со значениями должны автоматически удаляться из cache.
2. Реализуй логику метода getByKey:
2.1. Верни объект из cache для ключа key.
2.2. Если объекта не существует в кэше, то добавьте в кэш новый экземпляр используя рефлексию, см. пункт а).
3. Реализуй логику метода put:
3.1. Используя рефлексию получи ссылку на метод, описанный в пункте б).
3.2. Используя рефлексию разреши к нему доступ.
3.3. Используя рефлексию вызови метод getKey у объекта obj, таким образом ты получишь ключ key.
3.4. Добавь в кэш пару <key, obj>.
3.5. Верни true, если метод отработал корректно, false в противном случае. Исключения игнорируй.


Требования:
1. Поле cache должно быть инициализировано объектом типа WeakHashMap.
2. Метод getByKey должен возвращать объект из кеша.
3. Метод getByKey должен добавлять объект в кеш если его там нет.
4. Метод put должен извлекать из переданного объекта ключ и добавлять в кеш пару .
5. Метод put должен возвращать true, если он отработал корректно, иначе false.*/