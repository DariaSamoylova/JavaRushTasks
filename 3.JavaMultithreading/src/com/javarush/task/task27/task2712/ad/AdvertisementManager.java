package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by mr_ma on 25.05.2018.
 */
public class AdvertisementManager {
    final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private  int timeSeconds;
    private List<Advertisement> resultList = new ArrayList<>();
    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public  void processVideos() throws NoVideoAvailableException{
      /*  if (storage.list().isEmpty())
        throw new NoVideoAvailableException();

       List<Advertisement> list =   storage.list() ;
        Collections.sort(list);



        createOptimalVideoList(list);
        resultList.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                if (o1.getAmountPerOneDisplaying() >o2.getAmountPerOneDisplaying())
                    return -1;
                else if  (o1.getAmountPerOneDisplaying() <o2.getAmountPerOneDisplaying())
                    return 1;
                else{  if (o1.getAmountPerOneDisplaying()*1000/o1.getDuration() >o2.getAmountPerOneDisplaying()*1000/o2.getDuration())
                    return 1;
                else  if (o1.getAmountPerOneDisplaying()*1000/o1.getDuration() <o2.getAmountPerOneDisplaying()*1000/o2.getDuration())
                    return -1;
                    else return 0;

                }
            }
        });

        for(Advertisement a:resultList){
            System.out.println(a.getName()+" is displaying... "+a.getAmountPerOneDisplaying()+", "+a.getAmountPerOneDisplaying()*1000/a.getDuration());
        }*/
/*Third Video is displaying... 200, 333
First Video is displaying... 50, 277
Second Video is displaying... 10, 11*/
        List<Advertisement> advertisements = new ArrayList<>();
        for (Advertisement ad : storage.list())
        {
            if (ad.getHits() > 0)
            {
                advertisements.add(ad);
            }
        }
        if (advertisements.isEmpty()) throw new NoVideoAvailableException();
//amountPerOneDisplaying прописать (hits > 0) ? initialAmount / hits : 0.
        Collections.sort(advertisements, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result != 0) {
                    return -result;
                }

                long oneSecondCost1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                long oneSecondCost2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();

                return Long.compare(oneSecondCost1, oneSecondCost2);
            }
        });

        int totalDuration = 0;
        long totalAmount = 0;
        List<Advertisement> adsForShow = new ArrayList<>();

        for (Advertisement ad : advertisements) {
            totalAmount += ad.getAmountPerOneDisplaying();
            totalDuration += ad.getDuration();
            if (totalDuration <= timeSeconds && ad.getDuration() <= timeSeconds ) adsForShow.add(ad);
            else {
                totalAmount -= ad.getAmountPerOneDisplaying();
                totalDuration -= ad.getDuration();
            }
        }

        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(adsForShow, totalAmount, totalDuration));
//

        int timeLeft = timeSeconds;
        for (Advertisement advertisement : adsForShow) {
            if (timeLeft < advertisement.getDuration()) continue;

            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", "
                    + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());

            timeLeft -= advertisement.getDuration();
            advertisement.revalidate();
        }
    }




        public void createOptimalVideoList(List<Advertisement> list){

        for(Advertisement a:list){
            if (a.getHits()>0&&a.getDuration()<timeSeconds&&!resultList.contains(a)){
                resultList.add(a);
                a.revalidate();

            }
            if (!list.isEmpty()&&!isEmptyStorage(list)&&!resultList.contains(a))
                createOptimalVideoList(list);
        }
     }

     public boolean isEmptyStorage(List<Advertisement> kkk){

        for(Advertisement a:kkk){
            if (a.getHits()>0) {
                return false;

            }
        }
        return true;
     }
}
/*
Ресторан(10)
Рекурсию используют тогда, когда алгоритм решения задачи совпадает с алгоритмом решения подзадачи (части).
У нас как раз такой случай. Нам нужно сделать полный перебор всех вариантов и выбрать из них лучший.

Напомню, рекурсия пишется по следующему принципу:
а) условие выхода/окончания рекурсии
б) условие продолжения - вызов самой себя с набором параметров предыдущего шага.
В любое время ты можешь почитать в инете подробную информацию по написанию рекурсии.

Текущее задание - реализовать п.2.2 предыдущего задания с помощью рекурсии.
(подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду)
Рекурсивный метод должен выбрать набор рекламных роликов, которые будут показаны посетителю.

Этот набор должен удовлетворять следующим требованиям:
1. сумма денег, полученная от показов, должна быть максимальной из всех возможных вариантов
2. общее время показа рекламных роликов НЕ должно превышать время приготовления блюд для текущего заказа;
3. для одного заказа любой видео-ролик показывается не более одного раза;
4. если существует несколько вариантов набора видео-роликов с одинаковой суммой денег, полученной от показов, то:
4.1. выбрать тот вариант, у которого суммарное время максимальное;
4.2. если суммарное время у этих вариантов одинаковое, то выбрать вариант с минимальным количеством роликов;
5. количество показов у любого рекламного ролика из набора - положительное число.

Также не забудь реализовать п.2.4 из предыдущего задания (вывести на экран все подходящие ролики).

Для каждого показанного видео-ролика должен быть вызван метод revalidate().


---------------
4.
3.2. Разберем подробно метод void processVideos() в AdvertisementManager.
2.1. Удаляем из него вывод в консоль "calling processVideos method"
Метод должен:
2.2. Подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду. (Пока делать не нужно, сделаем позже).
2.3. Если нет рекламных видео, которые можно показать посетителю, то бросить NoVideoAvailableException, которое перехватить в оптимальном месте (подумать, где это место)
и с уровнем Level.INFO логировать фразу "No video is available for the order " + order
2.4. Отобразить все рекламные ролики, отобранные для показа, в порядке уменьшения
 стоимости показа одного рекламного ролика в копейках. Вторичная сортировка - по увеличению стоимости показа одной секунды рекламного ролика в тысячных частях копейки.
Используйте метод Collections.sort
(Тоже пока делать не нужно, сделаем позже).

Пример для заказа [Water]:
First Video is displaying... 50, 277
где First Video - название рекламного ролика
где 50 - стоимость показа одного рекламного ролика в копейках
где 277 - стоимость показа одной секунды рекламного ролика в тысячных частях копейки (равно 0.277 коп)
Используйте методы из класса Advertisement.
2.5. В классе Advertisement создайте метод void revalidate(). Этот метод должен:
2.5.1. Бросать UnsupportedOperationException, если количество показов не положительное число.
2.5.2. Уменьшать количество показов.

*/