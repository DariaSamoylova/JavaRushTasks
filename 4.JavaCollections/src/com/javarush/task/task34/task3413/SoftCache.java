package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);
if (softReference==null){
    return null;
} else
    return softReference.get();
        //напишите тут ваш код
    }

    public AnyObject put(Long key, AnyObject value) {
        if (cacheMap.get(key)==null)
            return null;
        SoftReference<AnyObject> anyObjectRef=cacheMap.get(key);
        AnyObject anyObject=anyObjectRef.get();
        anyObjectRef.clear();
        cacheMap.put(key, new SoftReference<>(value));
return anyObject;
        //напишите тут ваш код
    }

    public AnyObject remove(Long key) {
        if (cacheMap.get(key)==null)
            return null;
        SoftReference<AnyObject> anyObjectRef=cacheMap.get(key);
        AnyObject anyObject=anyObjectRef.get();
        anyObjectRef.clear();
        SoftReference<AnyObject> softReference = cacheMap.remove(key);
        return anyObject;
        //напишите тут ваш код
    }
}


/*Кеш на основании SoftReference
Реализуй логику методов get, put, remove класса SoftCache:

Метод AnyObject get(Long key) должен возвращать объект типа AnyObject из мапы cacheMap по ключу key. Если такого ключа в cacheMap нет - верни null.

Метод AnyObject put(Long key, AnyObject value) должен добавлять в мапу пару key : value. Метод должен вернуть null, если в cacheMap по такому ключу ранее не было значения.
Иначе - верни предыдущее значение value по этому ключу. Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.

Метод AnyObject remove(Long key) должен удалить из мапы cacheMap пару key : value по ключу key.
Метод должен вернуть null, если в cacheMap по такому ключу ранее не было значения. Иначе - верни предыдущее значение value по этому ключу. Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.

Не изменяй класс AnyObject.
Метод main не принимает участия в тестировании.


Требования:
1. Класс AnyObject не должен быть изменен.
2. В классе SoftCache должно существовать приватное поле Map> cacheMap.
3. Реализуй метод get согласно условию.
4. Реализуй метод put согласно условию.
5. Реализуй метод remove согласно условию.*/