package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers){
        Car c = null;
        if (type==0){
             c = new Truck(numberOfPassengers);
        }
      else  if (type==1){
             c = new Sedan(numberOfPassengers);
        }
       else if (type==2){
             c = new Cabriolet(numberOfPassengers);
        }
        return c;
    }


    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
           throw new Exception();
        fuel += numberOfLiters;

    }
    public  boolean isSummer(Date date , Date summerStart, Date summerEnd){
      if  (date.before(summerStart) || date.after(summerEnd)){
          return false;
      } else
          return  true;
    }
    public double getTripConsumption(Date date, int length, Date summerStart, Date summerEnd) {

        if (!isSummer(date,summerStart,summerEnd)) {
            return  getWinterConsumption(length);
        } else {
            return  getSummerConsumption(length);
        }

    }

    public  double    getWinterConsumption(int length){
       return length * winterFuelConsumption + winterWarmingUp;
   }


    public  double    getSummerConsumption(int length){
        return length * summerFuelConsumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
            return 0;


        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0)
            fastenPassengersBelts();
            fastenDriverBelt();

    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();/* {
        int MAX_TRUCK_SPEED = 80;
        int MAX_SEDAN_SPEED = 120;
        int MAX_CABRIOLET_SPEED = 90;
        if (type == TRUCK)
            return MAX_TRUCK_SPEED;
        if (type == SEDAN)
            return MAX_SEDAN_SPEED;
        return MAX_CABRIOLET_SPEED;
    }*/


    private boolean canPassengersBeTransferred(){
  return      isDriverAvailable()&&(fuel>0);
    }
}

/*Рефакторинг (11)
Рефакторинг (12)
12.1. Объединение условных операторов.
12.1.1. Добавь внутренний метод, сообщающий, могут ли быть перевезены пассажиры
boolean canPassengersBeTransferred() в класс Car. Метод должен возвращать true, если
водитель доступен isDriverAvailable и есть топливо fuel.
12.1.2. Перепиши метод getNumberOfPassengersCanBeTransferred(), объединив условные
операторы (используй метод canPassengersBeTransferred()).
12.2. Объединение дублирующихся фрагментов в условных операторах. Перепиши метод
startMoving(), чтобы в нем не было повторяющихся вызовов функций.
12.3. Замена магического числа символьной константой. Замени магические числа в методе
getMaxSpeed() на константные переменные метода: MAX_TRUCK_SPEED,
MAX_SEDAN_SPEED и MAX_CABRIOLET_SPEED.
12.4. Замена условного оператора полиморфизмом.
12.4.1. Переопредели метод getMaxSpeed() в подклассах, избавившись от условного оператора.
12.4.2. Метод getMaxSpeed() в классе Car сделай абстрактным.


Требования:
1. Необходимо создать приватный метод boolean canPassengersBeTransferred() в классе Car и реализовать его.
2. Необходимо изменить метод getNumberOfPassengersCanBeTransferred(), объединив условные операторы (используй метод canPassengersBeTransferred()).
3. Необходимо изменить метод startMoving(), чтобы в нем не было повторяющихся вызовов метода fastenDriverBelt().
4. Необходимо переопределить метод getMaxSpeed() в классе Truck. В методе нужно использовать константную переменную метода MAX_TRUCK_SPEED, значение которой равно 80.
5. Необходимо переопределить метод getMaxSpeed() в классе Sedan. В методе нужно использовать константную переменную метода MAX_SEDAN_SPEED, значение которой равно 120.
6. Необходимо переопределить метод getMaxSpeed() в классе Cabriolet. В методе нужно использовать константную переменную метода MAX_CABRIOLET_SPEED, значение которой равно 90.
7. Метод getMaxSpeed() в классе Car необходимо сделать абстрактным.*/