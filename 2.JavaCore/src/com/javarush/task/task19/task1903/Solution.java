package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static{
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {
      /*  IncomeData a = new IncomeData(){
            @Override
            public String getCountryCode() {
                return "38";
            }

            @Override
            public String getCompany() {
                return null;
            }

            @Override
            public String getContactFirstName() {
                return null;
            }

            @Override
            public String getContactLastName() {
                return null;
            }

            @Override
            public int getCountryPhoneCode() {
                return 0;
            }

            @Override
            public int getPhoneNumber() {
                return 501234567;
            }
        };

            ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }

            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };

        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
        Contact c = new IncomeDataAdapter(a);
        System.out.println(c.getPhoneNumber());*/
    }

    public static class IncomeDataAdapter implements Customer,Contact{
        private IncomeData data;

        public  IncomeDataAdapter(IncomeData data){
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName()+", "+data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String t=String.valueOf(data.getPhoneNumber());
            while (t.length() < 10) {
                t="0"+t;
            }

            return "+"+data.getCountryPhoneCode()+"("+t.substring(0,3)+")"+t.substring(3,6)+"-"+t.substring(6,8)+"-"+t.substring(8,10);
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
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
/*Адаптация нескольких интерфейсов
Адаптируй IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры).
Обратите внимание на формат вывода фамилии и имени человека.


Требования:
1. Класс Solution должен содержать public static поле countries типа Map.
2. В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
3. Класс IncomeDataAdapter должен реализовывать интерфейсы Customer и Contact.
4. Класс IncomeDataAdapter должен содержать приватное поле data типа IncomeData.
5. Класс IncomeDataAdapter должен содержать конструктор с параметром IncomeData.
6. В классе IncomeDataAdapter реализуй методы интерфейсов Customer и Contact используя подсказки в виде комментариев в интерфейсах.*/