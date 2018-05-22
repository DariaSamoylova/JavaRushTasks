package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
         allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
       //    allPeople.add(Person.createMale("qwe", new Date()));  //сегодня родился    id=0
       //  allPeople.add(Person.createMale("asd", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
     //  args=new String[2];
       /*  args[0]="-c";
        args[1]="qwe wer";
        args[2]="м";
        args[3]="15/04/1990";*/
      /*  args[0]="-u";
        args[2]="qwe wer";
        args[3]="м";
        args[4]="15/04/1990";
       args[1]="1";*/
        // args[0]="-i";
      //  args[1]="1";

        SimpleDateFormat frmat= new SimpleDateFormat( "dd/MM/yyyy" );
        SimpleDateFormat frma1t= new SimpleDateFormat( "dd-MMM-yyyy", Locale.ENGLISH);
        if (args[0].equals("-c")){
            allPeople.add(allPeople.size(),args[2].equals("ж")?Person.createFemale(args[1], frmat.parse(args[3])):Person.createMale(args[1],frmat.parse(args[3])));
            System.out.println(allPeople.size()-1);
        }
        else if (args[0].equals("-u")){
            allPeople.set(Integer.parseInt(args[1]),args[3].equals("ж")?Person.createFemale(args[2], frmat.parse(args[4])):Person.createMale(args[2],frmat.parse(args[4])));
        }
        else if (args[0].equals("-d")){
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
        }
        else if (args[0].equals("-i")){
            String d = ((allPeople.get(Integer.parseInt(args[1])).getSex()).equals(Sex.FEMALE))?"ж":"м";
           System.out.println(allPeople.get(Integer.parseInt(args[1])).getName()
                    +" "+d
                   +" "+frma1t.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));


        }
        /*
for(int i=0;i<allPeople.size();i++) {
    String d = ((allPeople.get(i).getSex()).equals(Sex.FEMALE)) ? "ж" : "м";
    System.out.println(allPeople.get(i).getName()
             + " " + d
             + " " + frma1t.format(allPeople.get(i).getBirthDay()));
}*/

    }
}

/*CRUD C:\Users\mr_ma\Documents\Даша\jv\JavaRushTasks\2.JavaCore\src\com\javarush\task\task17\task1710\Solution.java
CrUD — Create, Update, Delete

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name — имя, String
sex — пол, «м» или «ж», одна буква
bd — дата рождения в следующем формате 15/04/1990
-c — добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u — обновляет данные человека с данным id
-d — производит логическое удаление человека с id, заменяет все его данные на null
-i — выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
id соответствует индексу в списке

Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990


Требования:
1. Класс Solution должен содержать public static поле allPeople типа List.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
5. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
6. При запуске программы с параметром -i программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.*/