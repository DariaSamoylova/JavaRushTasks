package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mr_ma on 13.06.2018.
 */
public class DirectorTablet {

    public void printAdvertisementProfit()   {
        Map<Date, Long> map = StatisticManager.getInstance().getAmountForAdsPerDay();

        List<Date> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        long amount = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        for (Date d : list) {
            System.out.println(sdf.format(d) + " - " + map.get(d)/100);
            amount = amount+map.get(d);
        }
        System.out.println("Total - "+amount/100);
    }

    public void printCookWorkloading()   {
        Map<Date,Map<String,Integer>> map = StatisticManager.getInstance().getDurationCookingWorkPerCook();
        List<Date> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        for (Date d : list) {
            System.out.println(sdf.format(d)  );
            Map<String,Integer> tempMap = map.get(d);
            List<String> list2 = new ArrayList<>(tempMap.keySet());
            Collections.sort(list2);
            for (String s : list2) {
          //  for(Map.Entry<String,Integer> entry:tempMap.entrySet() ){
                System.out.println(s+" - "+Math.round(tempMap.get(s)/60 )+" min" );
            }
            System.out.println();
        }
    }

    public void printActiveVideoSet() {
    }

    public void printArchivedVideoSet() {
    }
}
/*3. 5. Реализуем логику метода printCookWorkloading в классе DirectorTablet.
Используя метод из предыдущего пункта вывести в консоль в убывающем порядке даты, имена поваров и время работы в минутах (округлить в большую сторону).
Для каждой даты из хранилища событий, для которой есть запись о работе повара, должна выводится продолжительность работы в минутах для этой даты.
Если повар не работал в какой-то из дней, то с пустыми данными его НЕ выводить (см. 13-May-2013)
Поваров сортировать по имени

Пример:
14-May-2013
Ivanov - 60 min
Petrov - 35 min

13-May-2013
Ivanov - 129 min

12-May-2013
Ivanov - 6 min
Petrov - 5 min


Требования:*/