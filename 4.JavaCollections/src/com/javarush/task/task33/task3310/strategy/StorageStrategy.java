package com.javarush.task.task33.task3310.strategy;

/**
 * Created by mr_ma on 19.02.2018.
 */
public interface StorageStrategy {
    boolean containsKey(Long key);

    boolean containsValue(String value);

    void put(Long key, String value);

    Long getKey(String value);
    String getValue(Long key);
}
/*boolean containsKey(Long key) - должен вернуть true, если хранилище
содержит переданный ключ.
2.2.2. boolean containsValue(String value) - должен вернуть true, если хранилище
содержит переданное значение.
2.2.3. void put(Long key, String value) - добавить в хранилище новую пару ключ -
значение.
2.2.4. Long getKey(String value) - вернуть ключ для переданного значения.
2.2.5. String getValue(Long key) - вернуть значение для переданного ключа.*/