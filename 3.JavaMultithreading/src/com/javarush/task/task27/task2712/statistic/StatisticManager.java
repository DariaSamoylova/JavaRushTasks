package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mr_ma on 08.06.2018.
 */
public class StatisticManager {
    private  static StatisticManager statisticManager;
    private StatisticStorage statisticStorage =  new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager(){

    }

    public static StatisticManager getInstance(){
        if (statisticManager==null)
            statisticManager=new StatisticManager();
        return statisticManager;
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    public  void register(Cook cook){
        cooks.add(cook);
    }

    private  class StatisticStorage{

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }

        Map<EventType, List<EventDataRow>> storage  = new HashMap<>();

        public StatisticStorage( ) {
            for(EventType e:EventType.values()){
                storage.put(e,new ArrayList<EventDataRow>());
            }

        }

        private void put(EventDataRow data){
            List<EventDataRow> tempList = storage.get(data.getType());
            tempList.add(data);
            storage.put(data.getType(),tempList);
        }
        //например используя цикл, для каждого EventType добавь new ArrayList<EventDataRow>()
    }


    public  Map<Date,Long> getAmountForAdsPerDay() throws ParseException {
         Map<Date,Long> resultMap = new HashMap();
        List<EventDataRow>  stor =  statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(EventDataRow e:stor){
            Date tempDate = sdf.parse(sdf.format(e.getDate()));
            if (resultMap.containsKey(tempDate)){
                for(Map.Entry<Date,Long> entry:resultMap.entrySet() ){
                    if (entry.getKey().equals(tempDate)) {
                        long am = entry.getValue();
                        resultMap.put(tempDate,am+((VideoSelectedEventDataRow)e).getAmount());
                    }
                }
            } else
                resultMap.put(tempDate, ((VideoSelectedEventDataRow)e).getAmount());


        }

        return  resultMap;
    }

   /* public  Map<String,Integer> getDurationCookingWorkPerCook() throws ParseException {
        Map<String,Map<Date,Integer>> resultMap = new HashMap();
        List<EventDataRow>  stor =  statisticStorage.getStorage().get(EventType.COOKED_ORDER);
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(EventDataRow e:stor){
          //  Date tempDate = sdf.parse(sdf.format(e.getDate()));
            String cookName= ((CookedOrderEventDataRow)e).getCookName();
            if (resultMap.containsKey(cookName)){
                for(Map.Entry<String,Integer> entry:resultMap.entrySet() ){
                    if (entry.getKey().equals(cookName)) {
                        int am = entry.getValue();
                        resultMap.put(cookName,am+((CookedOrderEventDataRow)e).getTime());
                    }
                }
            } else
                resultMap.put(cookName, ((CookedOrderEventDataRow)e).getTime());


        }

        return  resultMap;
    }*/

/*2.
В StatisticManager создай метод (придумать самостоятельно), который из хранилища достанет
все данные, относящиеся к работе повара, и посчитает общую продолжительность работы для каждого повара отдельно.

Date dateWithoutTime = sdf.parse(sdf.format(new Date()));
В StatisticManager создай метод (придумать самостоятельно), который из хранилища достанет все данные, относящиеся к отображению рекламы, и посчитает общую прибыль за каждый день.
Дополнительно добавь вспомогательный метод get в класс хранилища, чтобы получить доступ к данным.*/

}
