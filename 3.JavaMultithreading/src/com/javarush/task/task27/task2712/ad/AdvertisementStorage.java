package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr_ma on 25.05.2018.
 */
public class AdvertisementStorage {
  private static AdvertisementStorage advertisementStorage;
private final List<Advertisement> videos = new ArrayList();

    private  AdvertisementStorage() {
      Object someContent = new Object();
     add( new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        add(  new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        add(  new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min
    }


    public static AdvertisementStorage getInstance(){
      if (advertisementStorage==null)
          advertisementStorage = new AdvertisementStorage();

      return advertisementStorage;
    }
public List<Advertisement>  list(){
      return videos;
}


public void add(Advertisement advertisement){
  videos.add(advertisement);
}

}
/*Опишем его.
1. Видео должно где-то храниться, пусть это будет список.
Создадим поле videos и инициализируем его пустым листом.
Подумай, должно ли поле videos иметь возможность менять свое значение?

2. Чтобы как-то работать с видео, создай публичные методы:
2.1. list() - который вернет список всех существующих доступных видео.
2.2. add(Advertisement advertisement) - который добавит новое видео в список videos.

3. В конструкторе класса добавим в список videos какие-то данные. У меня это:
Object someContent = new Object();
new Advertisement(someContent, "First Video", 5000, 100, 3 * 60) // 3 min
new Advertisement(someContent, "Second Video", 100, 10, 15 * 60) //15 min
new Advertisement(someContent, "Third Video", 400, 2, 10 * 60) //10 min

4. В AdvertisementManager создадим final поле-ссылку на экземпляр AdvertisementStorage и назовем ее storage.
Не забудь инициализировать созданное поле!*/