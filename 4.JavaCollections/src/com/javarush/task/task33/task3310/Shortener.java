package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

/**
 * Created by mr_ma on 19.02.2018.
 */
public class Shortener {
    private  Long lastId=0L;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string){
        if (storageStrategy.containsValue(string)){
            return storageStrategy.getKey(string);
        } else {
            lastId++;
            storageStrategy.put(lastId,string);
            return lastId;
        }

    }

    public    synchronized String  getString(Long id){
        return storageStrategy.getValue(id);
    }
}
/*Вернемся к классу Shortener:
3.1. Добавь в него поле Long lastId. Проинициализируй его нулем. Это поле будет
отвечать за последнее значение идентификатора, которое было использовано при добавлении новой строки в хранилище.
3.2. Добавь поле StorageStrategy storageStrategy в котором будет храниться стратегия хранения данных.
3.3. Добавь конструктор, который принимает StorageStrategy и инициализирует соответствующее поле класса.
3.4. Реализуй метод getId, он должен:
3.4.1. Проверить есть ли переданное значение в хранилище, если есть - вернуть его ключ.
3.4.2. Если преданного значения нет в хранилище, то:
3.4.2.1. Увеличить значение lastId на единицу;
3.4.2.2. Добавить в хранилище новую пару ключ-значение (новое значение lastId и переданную строку);
3.4.2.3. Вернуть новое значение lastId.
3.5. Реализуй метод getString, он должен вернуть строку по заданному идентификатору (ключу).
3.6. Предусмотреть возможность вызова методов getId и getString из разных потоков добавив соответствующий модификатор к заголовкам методов.


Требования:
1. В классе Shortener должно быть создано приватное поле Long lastId инициализированное нулем.
2. В классе Shortener должно быть создано приватное поле storageStrategy типа StorageStrategy.
3. Конструктор класса Shortener должен принимать один параметр типа StorageStrategy и инициализировать им поле storageStrategy.
4. Метод getId должен быть реализован в соответствии с условием задачи.
5. Метод getString должен быть реализован в соответствии с условием задачи.*/