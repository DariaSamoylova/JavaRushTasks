package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements  Alive {
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;


   // protected int[] size;
   protected Size size ;//= new Size();
    private List<Human> children = new ArrayList<>();
  //  protected boolean isSoldier;

 //   public static final int FIRST = 1;
  //  public static final int SECOND = 2;
  //  public static final int THIRD = 3;
   // public static final int FOURTH = 4;
 //  private int bloodGroup;
    private  BloodGroup bloodGroup;


    public class Size{
        public int height;
        public int weight;
    }
/* int code, приватный конструктор,
принимающий int и инициализирующий поле code, геттер для поля класса.
9.4.3. Добавь в класс BloodGroup статические методы first(), second(), third() и fourth(),
создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри (1, 2, 3 и 4 соответственно).
9.4.4. Примени в классе Human новый тип BloodGroup.*/

   /*     public void setBloodGroup(BloodGroup b) {
        bloodGroup=b;
    switch   (code) {
            case 1:
                bloodGroup = BloodGroup.first();break;
            case 2:
                bloodGroup = BloodGroup.second();break;
            case 3:
                bloodGroup = BloodGroup.third();break;
            case 4:
                bloodGroup = BloodGroup.fourth();break;
        }

    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }*/

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {

        return bloodGroup;
    }

    public List<Human> getChildren() {
       // return children;
        return   Collections.unmodifiableList(children);
    }

   /* public void setChildren(List<Human> children) {
        this.children = children;
    }*/
   public void  addChild(Human h){
       children.add(h);
   }
   public void removeChild(Human h){
       children.remove(h);
   }

  //  public Human(boolean isSoldier) {
  public Human(String name,int age) {
      //  this.isSoldier = isSoldier;
      this.name = name;
      this.age = age;
        this.id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition(){
      return "Человек";
    }

    public void live() {
      //  if (isSoldier)
      //      fight();
    }

   // public void fight() {
  //  }

    public int getId() {
        return id;
    }



    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public void printData() {
        System.out.println(getPosition()+": " + name);
    }

}
/*Рефакторинг (5)
5.1. Создание шаблонного метода.
5.1.1. Добавь в класс Human метод String getPosition(), который должен возвращать строку «Человек«.
5.1.2. Переопредели этот метод в классе Student и Teacher. Метод должен возвращать «Студент» и «Преподаватель» соответственно.
5.1.3. Замени метод printData в подклассах шаблонным методом в базовом классе, использующим getPosition().
5.2. Замена делегирования наследованием. Класс Worker должен наследоваться от Human, а не содержать его.
5.3. Переименование метода. Переименуй метод setSlr, чтобы было понятно сеттером чего является этот метод.


Требования:
1. В классе Human должен существовать метод String getPosition(), который возвращает строку "Человек".
2. В классе Student переопредели метод String getPosition(), чтобы он возвращал строку "Студент".
3. В классе Teacher переопредели метод String getPosition(), чтобы он возвращал строку "Преподаватель".
4. Необходимо заменить метод printData() в классе Student на метод printData() в классе Human. Используй getPosition().
5. Необходимо заменить метод printData() в классе Teacher на метод printData() в классе Human. Используй getPosition().
6. Класс Worker должен наследоваться от класса Human, а не содержать его.
7. В классе Worker необходимо переименовать метод setSlr(double) на setSalary(double).*/