package com.javarush.task.task21.task2113;

/**
 * Created by mr_ma on 20.10.2017.
 */
public class Horse {
    String name;
    double speed,distance;

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {

        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public Horse(String name, double speed, double distance) {

        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    void move(){
        distance += Math.random()*speed;
    }

    void print(){
        for(int i=0;i<Math.floor(distance);i++){
            System.out.print(".");
        }
        System.out.print(name);
        System.out.println();
    }
}

/*Ипподром(4)
Ипподром(13)
Теперь вернемся к методу print класса Horse.

Т.к. мы работаем с консолью, то все лошади на бегах будут выглядеть примерно так:
........Sleven <- лошадь Слевин
....Lucky <- лошадь Лаки
..........Gomer <- лошадь Гомер

Другими словами, в методе print надо вывести на экран строку состоящую из точек и имени лошади.
Количество точек равно distance, округленному (в меньшую сторону) до целого числа.


Требования:
1. Метод print должен выводить на экран строку состоящую из точек и имени лошади. Количество точек равно целой части distance.
*/