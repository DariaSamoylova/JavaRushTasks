package com.javarush.task.task37.task3701;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
   // private int size=this.size();
   // transient Object[] elementDataNew=this.toArray();

    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
      //  System.out.print(list);
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        //return super.iterator();
        return  new RoundIterator();
    }

    public class RoundIterator implements  Iterator {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;
        @Override
        public boolean hasNext() {
            return Solution.this.size()!=0;
            //return cursor != Solution.this.size();
        //    return false;
        }

        @Override
        public T next() {
             checkForComodification();
            int i = cursor;
            if (i >= Solution.this.size())
              //  throw new NoSuchElementException();
                i=0;
            Object[] elementData =  Solution.this.toArray();// elementDataNew;
            if (i >= elementData.length)
              i=0;//  throw new ConcurrentModificationException();
            cursor = i + 1;
            return (T) elementData[lastRet = i];
           // return null;
        }

        @Override
        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                Solution.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

}
/*
        Итератор должен ходить по кругу по всем элементам.
        В остальном поведение должно быть идентичным текущему итератору.


        Требования:
        1. Круговой итератор должен после последнего элемента переходить на первый и так далее.
        2. Метод remove без параметров должен удалять текущий элемент.
        3. При некорректной модификации списка из разных потоков должно возникать исключение ConcurrentModificationException.
 private class Itr implements Iterator<E> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                ArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            final int size = ArrayList.this.size;
            int i = cursor;
            if (i >= size) {
                return;
            }
            final Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            while (i != size && modCount == expectedModCount) {
                consumer.accept((E) elementData[i++]);
            }
            // update once at end of iteration to reduce heap write traffic
            cursor = i;
            lastRet = i - 1;
            checkForComodification();
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
    Круговой итератор
        Класс Solution наследуется от ArrayList.
        Перегрузи правильным образом метод iterator в классе Solution.

        4. Класс Solution должен быть потомком класса ArrayList.
        5. Метод iterator() в классе Solution должен возвращать объект типа RoundIterator.*/