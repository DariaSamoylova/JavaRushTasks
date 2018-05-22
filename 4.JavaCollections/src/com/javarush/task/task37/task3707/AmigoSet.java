package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by mr_ma on 23.01.2018.
 */
public class AmigoSet<E> extends AbstractSet<E> implements  Cloneable,Serializable,Set<E> {
    private static final Object PRESENT= new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> c) {


        map = new HashMap<>(Math.max((int) (c.size() / .75f) + 1, 16));
        addAll(c);

    }

    @Override
    public Iterator iterator() {
        return  map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)==null;
    }

    @Override
    public void clear() {
        map.clear();
    }
    public  Object clone(){
          AmigoSet copy;
        try {
            copy = (AmigoSet) super.clone();
            copy.map = (HashMap) map.clone();
        } catch (Exception e) {
            throw new InternalError(e);
        }

        return copy; 
    }


    private void writeObject(ObjectOutputStream oos) {

        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        int buckets = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        try {
            oos.defaultWriteObject();
            oos.writeInt(buckets);
            oos.writeFloat(loadFactor);
        } catch (IOException e) {

        }
    }

    private void readObject(ObjectInputStream s) {
        try {
            s.defaultReadObject();
            int bucket = s.readInt();
            float loadFactor = s.readFloat();
            HashMap<E, Object> map = new HashMap<E, Object>(bucket, loadFactor);

        } catch (Exception e) {

        }
    }
/*
    private final void writeObject(ObjectOutputStream oos)   {

        try {
            oos.defaultWriteObject();
           float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
            int buckets = HashMapReflectionHelper.callHiddenMethod(map, "capacity");

            oos.defaultWriteObject();
            oos.writeInt(buckets);
            oos.writeFloat(loadFactor);
            oos.writeInt( map.size());
            for (E e : map.keySet())
                oos.writeObject(e);
        } catch (IOException e) {

        }
    }*/

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

   /* private final void readObject(ObjectInputStream s) {
        try {
      s.defaultReadObject();

           int bucket = s.readInt();
            float loadFactor = s.readFloat();
            int ss = s.readInt();
           //  HashMap<E, Object>
                     map = new HashMap<E, Object>(bucket, loadFactor);
          //  map = new HashMap<E, Object>(ss);
            for (int i=0; i<ss; i++) {

                E e = (E) s.readObject();
                map.put(e, PRESENT);
            }
        } catch (Exception e) {

        }
    }*/
}
/*

private void readObject(java.io.ObjectInputStream s)
        throws java.io.IOException, ClassNotFoundException {
    // Read in any hidden serialization magic
    s.defaultReadObject();

    // Read capacity and verify non-negative.
    int capacity = s.readInt();
    if (capacity < 0) {
        throw new InvalidObjectException("Illegal capacity: " +
                capacity);
    }

    // Read load factor and verify positive and non NaN.
    float loadFactor = s.readFloat();
    if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
        throw new InvalidObjectException("Illegal load factor: " +
                loadFactor);
    }

    // Read size and verify non-negative.
    int size = s.readInt();
    if (size < 0) {
        throw new InvalidObjectException("Illegal size: " +
                size);
    }

    // Set the capacity according to the size and load factor ensuring that
    // the HashMap is at least 25% full but clamping to maximum capacity.
    capacity = (int) Math.min(size * Math.min(1 / loadFactor, 4.0f),
            HashMap.MAXIMUM_CAPACITY);

    // Create backing HashMap
    map = (((HashSet<?>)this) instanceof LinkedHashSet ?
            new LinkedHashMap<E,Object>(capacity, loadFactor) :
            new HashMap<E,Object>(capacity, loadFactor));

    // Read in all elements in the proper order.
    for (int i=0; i<size; i++) {
        @SuppressWarnings("unchecked")
        E e = (E) s.readObject();
        map.put(e, PRESENT);
    }
}*/
/*AmigoSet (3)
Твое собственное множество AmigoSet реализует интерфейс Serializable. Однако, не сериализуется правильно.

1. Реализуй свою логику сериализации и десериализации.
Вспоминай, какие именно приватные методы нужно добавить, чтоб сериализация пошла по твоему сценарию.
Для сериализации:
* сериализуй сет
* сериализуй capacity и loadFactor у объекта map, они понадобятся для десериализации.
Т.к. эти данные ограничены пакетом, то воспользуйся утилитным классом HashMapReflectionHelper, чтобы достать их.

Для десериализации:
* вычитай все данные
* создай мапу используя конструктор с capacity и loadFactor

2. Помнишь, что такое transient?


Требования:
1. В классе AmigoSet должен содержаться private метод writeObject с одним параметром типа ObjectOutputStream.
2. В классе AmigoSet должен содержаться private метод readObject с одним параметром типа ObjectInputStream.
3. Объект сериализованный с помощью метода writeObject должен быть равен объекту десериализованному с помощью метода readObject.
4. В методе writeObject должен быть вызван метод defaultWriteObject на объекте типа ObjectOutputStream полученном в качестве параметра.
5. В методе readObject должен быть вызван метод defaultReadObject на объекте типа ObjectInputStream полученном в качестве параметра.

*/