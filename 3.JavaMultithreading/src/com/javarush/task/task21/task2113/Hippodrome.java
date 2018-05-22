package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr_ma on 20.10.2017.
 */
public class Hippodrome {
    private List<Horse> horses ;
    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List list)
    {
        horses=list;
    }


    public static void main(String[] args) throws InterruptedException {
       game = new Hippodrome(new ArrayList<Horse>());
       Horse h1 = new Horse("h1",3,0);
        Horse h2 = new Horse("h2",3,0);
        Horse h3 = new Horse("h3",3,0);
        game.getHorses().add(h1);
        game.getHorses().add(h2);
        game.getHorses().add(h3);
        game.run();
 game.printWinner();
    }

    void run() throws InterruptedException {
for(int i=1;i<=100;i++){
    move();
    print();
    Thread.sleep(200);
}
    }

    void move(){
        for(Horse h:horses){
            h.move();
        }
    }
    void print(){
        for(Horse h:horses){
            h.print();
        }
        for(int i=0;i<10;i++){
            System.out.println();
        }
    }

    public Horse getWinner(){
       double max = Double.MIN_VALUE;
       Horse g=null;
        for(Horse h:horses){
            if (h.getDistance()>max){
                max=h.getDistance();
                g=h;
            }
        }
        return g;
    }

    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
}
 /*Ипподром(4)
Ипподром(15)
Добавим определение победителя.
В классе Hippodrome сделаем два метода:
public Horse getWinner() и public void printWinner()

Метод getWinner должен возвращать лошадь пробежавшую самую большую дистанцию.
Метод printWinner выводит на экран имя победителя в виде: Winner is <name>!

Пример:
Winner is Lucky!


Требования:
1. В классе Hippodrome должен быть создан метод getWinner без параметров.
2. В классе Hippodrome должен быть создан метод printWinner без параметров.
3. Метод getWinner должен возвращать лошадь пробежавшую наибольшую дистанцию.
4. Метод printWinner должен выводить на экран имя победителя на экран в формате заданном в условии задачи.
*/