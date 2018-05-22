package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mr_ma on 29.03.2018.
 */
public class CurrencyManipulator {
    private  String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode.toUpperCase();
    }

    public String getCurrencyCode() {

        return currencyCode;
    }

    public  void addAmount(int denomination, int count){
        if (!denominations.containsKey(denomination))
            denominations.put(denomination,count);
        else {
            
            Integer a = denominations.get(denomination) + count;
            denominations.put(denomination, a);
        }

    }

  public   int getTotalAmount(){
        int sum=0;
        for(Map.Entry<Integer,Integer> entry:denominations.entrySet()){
            sum=sum+entry.getKey()*entry.getValue();
        }
        return sum;
    }


    public  boolean hasMoney(){
      return  getTotalAmount()==0?false:true;
    }

    public boolean isAmountAvailable(int expectedAmount){
        return getTotalAmount()>=expectedAmount;
    }



    public  Map<Integer, Integer> withdrawAmount (int expectedAmount) throws NotEnoughMoneyException,ConcurrentModificationException {
        ArrayList<Integer> arrayList= new ArrayList<>(denominations.keySet());
        Collections.sort(arrayList);
        Map<Integer, Integer> resultMoney=new ConcurrentHashMap<>();
        int kolvo;
        int ostatokExpectedAmount = expectedAmount;
        int nominal;

        for(int i=arrayList.size()-1;i>=0;i--) {
            nominal= arrayList.get(i);
           if (ostatokExpectedAmount>=nominal&&denominations.get(nominal)>0) {
               kolvo = ostatokExpectedAmount / nominal;
              int ostatokVBanke=kolvo<=denominations.get(nominal)?(denominations.get(nominal)-kolvo):0;
               resultMoney.put(nominal,kolvo<=denominations.get(nominal)?kolvo:denominations.get(nominal));
               //denominations.put(nominal,ostatokVBanke);
               ostatokExpectedAmount=ostatokExpectedAmount-nominal*resultMoney.get(nominal);
           }


        }



        if (ostatokExpectedAmount!=0)
            throw new NotEnoughMoneyException();
        else
        {
            for(Map.Entry<Integer, Integer> entry:resultMoney.entrySet()){
                int nominal1 = entry.getKey();
                denominations.put(nominal1,denominations.get(nominal1)-entry.getValue());
            }
        }


        return resultMoney;
    }
}
/*
Убедись, что метод withdrawAmount(int expectedAmount) не меняет значение denominations в манипуляторе, если нечем выдать нужную сумму.


12. Логика основного метода withdrawAmount:
2.1. Внимание!!! Метод withdrawAmount должен возвращать минимальное количество банкнот, которыми набирается запрашиваемая сумма.
Используйте Жадный алгоритм (use google).
Если есть несколько вариантов, то использовать тот, в котором максимальное количество банкнот высшего номинала.
Если для суммы 600 результат - три банкноты: 500 + 50 + 50 = 200 + 200 + 200, то выдать первый вариант.

Пример, надо выдать 600.
В манипуляторе есть следующие банкноты:
500 - 2
200 - 3
100 - 1
50 - 12

Результат должен быть таким:
500 - 1
100 - 1

т.е. всего две банкноты (это минимальное количество банкнот) номиналом 500 и 100.

2.2. Мы же не можем одни и те же банкноты выдавать несколько раз, поэтому
если мы нашли вариант выдачи денег (п.2.1. успешен), то вычесть все эти банкноты из карты в манипуляторе.

2.3. метод withdrawAmount должен кидать NotEnoughMoneyException, если купюрами невозможно выдать запрашиваемую сумму.

Пример, надо выдать 600.
В манипуляторе есть следующие банкноты:
500 - 2
200 - 2

Результат - данными банкнотами невозможно выдать запрашиваемую сумму. Кинуть исключение.
Не забудьте, что в некоторых случаях картой кидается ConcurrentModificationException. */