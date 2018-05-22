package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr_ma on 02.01.2018.
 */
@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    public int count;
    public       double profit;
    //@XmlAnyElement
   // public ArrayList<String> secretData;
    public  String[] secretData;
    public  Goods goods;
    @XmlType(name = "goods")
    public static class Goods{
        @XmlAnyElement
        public List<String> names = new ArrayList<>() ;
      //  Goods(){
       //     names
       // }

    }
}
