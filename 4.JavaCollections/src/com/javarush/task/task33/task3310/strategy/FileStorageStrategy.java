package com.javarush.task.task33.task3310.strategy;

/**
 * Created by mr_ma on 22.02.2018.
 */
public class FileStorageStrategy implements  StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private long bucketSizeLimit = 10000;


    private  static final long DEFAULT_BUCKET_SIZE_LIMIT=10000;

    private  long maxBucketSize=DEFAULT_BUCKET_SIZE_LIMIT;




    public FileStorageStrategy() {
        for (int i = 0; i < table.length; i++) {
            table[i] = new FileBucket();
        }
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            Entry entry = table[i].getEntry();
            while (entry != null) {
                if (entry.value.equals(value)) return true;
                entry = entry.next;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        if (table[index] != null) {
            Entry entry = table[index].getEntry();
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            addEntry(hash, key, value, index);
        }
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            Entry entry = table[i].getEntry();
            while (entry != null) {
                if (entry.value.equals(value)) return entry.key;
                entry = entry.next;
            }
        }
        return 0l;
    }

    @Override
    public String getValue(Long key) {
        if (key == null)
            return null;
        Entry entry = getEntry(key);
        return null == entry ? null : entry.getValue();
    }

    int hash(Long k) {
        long h = k;
        h ^= (h >>> 20) ^ (h >>> 12);
        return (int) (h ^ (h >>> 7) ^ (h >>> 4));
    }

    int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    Entry getEntry(Long key) {
        int hash = (key == null) ? 0 : hash(key);
        for (Entry e = table[indexFor(hash, table.length)].getEntry();
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }

    void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    void transfer(FileBucket[] newTable) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            Entry entry = table[i].getEntry();
            while (entry != null) {
                Entry next = entry.next;
                int newIndex = indexFor(entry.hash, newTable.length);
                if (newTable[newIndex] == null) {
                    entry.next = null;
                    newTable[newIndex] = new FileBucket();
                } else {
                    entry.next = newTable[newIndex].getEntry();
                }
                newTable[newIndex].putEntry(entry);
                entry = next;
            }
            table[i].remove();
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        createEntry(hash, key, value, bucketIndex);
        if (table[bucketIndex].getFileSize() > bucketSizeLimit) resize(2 * table.length);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        size++;
    }
}


        /*
    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    int size;
    static final long DEFAULT_BUCKET_SIZE_LIMIT=10000;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize=DEFAULT_BUCKET_SIZE_LIMIT;



    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    public long getBucketSizeLimit() {

        return bucketSizeLimit;
    }


    @Override
    public boolean containsKey(Long key) {
        for (FileBucket f:table ){
            Entry e=  f.getEntry();
           if (  e.getKey()==key) return true;
        }
        return false;

    }

    @Override
    public boolean containsValue(String value) {
      for (FileBucket f:table ){
          Entry e=  f.getEntry();
          if (value.equals(e.value))
              return true;
      }

        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key );
        int i = indexFor(hash, table.length);*/
/*
                  for (Entry  e = table[i]; e != null; e = e.next) {
                          Object k;
                          if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                              String oldValue = e.value;
                                  e.value = value;
                                 // e.recordAccess(this);
                                 // return oldValue;
                              return;
                              }
                      }

                 // modCount++;
                  addEntry(hash, key, value, i);*/
  /*  }

    @Override
    public Long getKey(String value) {
        return null;
    }

    @Override
    public String getValue(Long key) {
        return null;
    }
    int hash(Long k){
        int h= k.hashCode();

        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }


    int indexFor(int hash, int length){
        return hash & (length-1);
    }

*/

  //  void resize(int newCapacity) {
   //     FileBucket[] newTable = new FileBucket[newCapacity];
   //     transfer(newTable);
   //     table = newTable;
      //  FileBucket[] newTable= table;
      //  FileBucket  oldBucket;
     //  FileBucket[] oldTable = table;
     //    int oldCapacity = oldTable.length;
    //    for(int i=0;i<oldTable.length;i++){
    //        if (oldTable[i].getFileSize()>bucketSizeLimit) {
            //    oldBucket = table[i];
    //            newTable=new FileBucket[oldCapacity++];
    //        }

  //      }
   //     transfer(newTable );
   //     table = newTable;
       /* if (oldCapacity == (1 << 30)) {
            // Setting next size to max
            threshold = Integer.MAX_VALUE;
            return;
        }
        Entry[] newTable = new Entry[newCapacity];
        // move all items to new hash table
        transfer(newTable );
        table = newTable;
        threshold = (int)Math.min(newCapacity * loadFactor, (1 << 30) + 1);*/
   // }


  /*  public void transfer(FileBucket[] newTable) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            Entry entry = table[i].getEntry();
            while (entry != null) {
                Entry next = entry.next;
                int newIndex = indexFor(entry.hash, newTable.length);
                if (newTable[newIndex] == null) {
                    entry.next = null;
                    newTable[newIndex] = new FileBucket();
                } else {
                    entry.next = newTable[newIndex].getEntry();
                }
                newTable[newIndex].putEntry(entry);
                entry = next;
            }
            table[i].remove();
        }
    }
*/

  /*  public void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry entry = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, entry));
        size++;
        if (table[bucketIndex].getFileSize() > bucketSizeLimit)
            resize(2 * table.length);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        table[bucketIndex] = new FileBucket();
        table[bucketIndex].putEntry(new Entry(hash, key, value, null));
        size++;
    }*/




















/*
    Entry getEntry(Long key){
        int hash = (key == null) ? 0 :  hash(key );
        for (Entry  e = table[indexFor(hash, table.length)];
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;

    }

    void resize(int newCapacity) {


        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == (1 << 30)) {
            // Setting next size to max
            threshold = Integer.MAX_VALUE;
            return;
        }
        Entry[] newTable = new Entry[newCapacity];
        // move all items to new hash table
        transfer(newTable );
        table = newTable;
        threshold = (int)Math.min(newCapacity * loadFactor, (1 << 30) + 1);
    }

    void transfer(Entry[] newTable){
        Entry[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry  e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Entry  next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }
    void addEntry(int hash, Long key, String value, int bucketIndex){
        Entry  e = table[bucketIndex];
        table[bucketIndex] = new Entry (hash, key, value, e);
        if (size++ >= threshold)
            resize(2 * table.length);
    }
    void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry  e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        size++;
    }*/

/*Создай и реализуй класс FileStorageStrategy. Он должен:
10.1. Реализовывать интерфейс StorageStrategy.
10.2. Использовать FileBucket в качестве ведер (англ. bucket).

Подсказка: класс должен содержать поле FileBucket[] table.

10.3. Работать аналогично тому, как это делает OurHashMapStorageStrategy,
но удваивать количество ведер не когда количество элементов size станет больше какого-то порога,
 а когда размер одного из ведер (файлов) стал больше bucketSizeLimit.
10.3.1. Добавь в класс поле long bucketSizeLimit.
10.3.2. Проинициализируй его значением по умолчанию, например, 10000 байт.
10.3.3. Добавь сеттер и геттер для этого поля.
10.4. При реализации метода resize(int newCapacity) проследи, чтобы уже не нужные файлы были удалены (вызови метод remove()).
Проверь новую стратегию в методе main(). Учти, что стратегия FileStorageStrategy гораздо более медленная, чем остальные. Не используй большое количество элементов для теста, это может занять оооочень много времени.
Запусти программу и сравни скорость работы всех 3х стратегий.

Запусти программу и сравни скорость работы всех 3х стратегий.
P.S. Обрати внимание на наличие всех необходимых полей в классе FileStorageStrategy, по аналогии с OurHashMapStorageStrategy:
static final int DEFAULT_INITIAL_CAPACITY
static final long DEFAULT_BUCKET_SIZE_LIMIT
FileBucket[] table
int size
private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT
long maxBucketSize


Требования:
1. Класс FileStorageStrategy должен поддерживать интерфейс StorageStrategy.
2. В классе FileStorageStrategy должны быть созданы все необходимые поля (согласно условию задачи).
3. Методы интерфейса StorageStrategy должны быть реализованы в FileStorageStrategy таким образом, чтобы обеспечивать корректную работу Shortener созданного на его основе.
*/