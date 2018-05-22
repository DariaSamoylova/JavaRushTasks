package com.javarush.task.task14.task1408;

/**
 * Created by mr_ma on 26.09.2017.
 */
public class BelarusianHen extends Hen {
    public   int getCountOfEggsPerMonth(){
        return 20;
    }


    public String getDescription(){
        return super.getDescription()+" Моя страна - " + Country.BELARUS+". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}
//return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";