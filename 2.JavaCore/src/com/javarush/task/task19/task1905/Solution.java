package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static{
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static void main(String[] args) {
      /* String g = "+38(050)123-45-67";
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(g);

        String h="";
        while (m.find()) {
           h=h+m.group();
        };
 System.out.println( h);*/
    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String r=null;
            for(Map.Entry<String,String> k:countries.entrySet()){
                if (k.getValue().equals(customer.getCountryName()))
                    r=k.getKey();
            }
            return r;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] a = contact.getName().split(" ");
            return a[1];
        }

        @Override
        public String getContactLastName() {
            String[] a = contact.getName().split(",");
            return a[0];
        }

        @Override
        public String getDialString() {
            String g=contact.getPhoneNumber();
            Pattern p = Pattern.compile("[0-9]");
            Matcher m = p.matcher(g);

            String h="";
            while (m.find()) {
                h=h+m.group();
            }
            return "callto://+"+h;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}

/*Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.

Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada


Требования:
1. Класс Solution должен содержать public static поле countries типа Map.
2. В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
3. Класс Solution должен содержать интерфейс RowItem.
4. Класс Solution должен содержать интерфейс Contact.
5. Класс Solution должен содержать интерфейс Customer.
6. Класс DataAdapter должен реализовывать интерфейс RowItem.
7. Класс DataAdapter должен содержать два приватных поля: customer типа Customer и contact Contact.
8. Класс DataAdapter должен содержать конструктор с параметрами (Customer customer, Contact contact), который инициализирует поля contact и customer.
9. В классе DataAdapter реализуй методы интерфейса RowItem используя подсказки в виде комментариев в интерфейсах.*/