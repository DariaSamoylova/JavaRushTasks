package com.javarush.task.task28.task2811;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteMap<K, V> {
    private final Map<K, V> map;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public ReadWriteMap(Map<K, V> map) {
        this.map = map;
    }

    public V put(K key, V value) {
        writeLock.lock();
        try {
            return map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public V get(K key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
readLock.unlock();
        }
    }
}
/*ReentrantReadWriteLock
Класс ReadWriteMap должен предоставлять корректный доступ к объекту Map из многих потоков, но в его реализации были допущены ошибки. Найди их и исправь.

P.S. Для корректной работы Map в многопоточной среде, желательно пользоваться стандартной реализацией, например ConcurrentHashMap из пакета java.util.concurrent.
Но иногда требуется работа с другим типом мапы, например LinkedHashMap и тогда предложенное решение будет как никогда кстати.


Требования:
1. Поле readLock должно быть инициализировано с помощью метода readLock вызванного на объекте lock.
2. Поле writeLock должно быть инициализировано с помощью метода writeLock вызванного на объекте lock.
3. В методе put должен быть вызван метод lock на объекте writeLock.
4. В методе get должен быть вызван метод lock на объекте readLock.
5. В методе put в блоке finally должен быть вызван метод unlock на объекте writeLock.
6. В методе get в блоке finally должен быть вызван метод unlock на объекте readLock.*/