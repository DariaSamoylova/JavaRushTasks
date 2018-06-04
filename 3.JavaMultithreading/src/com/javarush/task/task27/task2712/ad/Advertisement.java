package com.javarush.task.task27.task2712.ad;

import java.util.Comparator;

/**
 * Created by mr_ma on 25.05.2018.
 */
public class Advertisement implements Comparable {
 private    Object content;// видео
    private  String name;// имя/название
    private  long initialAmount;// начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private  int hits;// количество оплаченных показов
    private  int duration;// продолжительность в секундах
    private  long amountPerOneDisplaying;

    public long getInitialAmount() {
        return initialAmount;
    }

    public int getHits() {
        return hits;
    }

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = initialAmount/hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }
    public  void revalidate(){
        if(hits<=0){
            throw new UnsupportedOperationException();
        }
        hits--;
    }



    @Override
    public int compareTo(Object o) {
        if (this.initialAmount>((Advertisement)o ).initialAmount)
            return -1;
        else if  (this.initialAmount<((Advertisement)o ).initialAmount)
            return 1;
        else {
            if (this.duration>((Advertisement)o ).duration)
                return -1;
            else if(this.duration<((Advertisement)o ).duration)
                return 1;
            else{
                if (this.hits>((Advertisement)o ).hits)
                    return  1;
                else if(this.hits<((Advertisement)o ).hits)
                    return -1;
                else
                    return 0;
            }

        }
    }
}
/*П2.5. В классе Advertisement создайте метод void revalidate(). Этот метод должен:
2.5.1. Бросать UnsupportedOperationException, если количество показов не положительное число.
2.5.2. Уменьшать количество показов.

!*/