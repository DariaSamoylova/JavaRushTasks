package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by mr_ma on 24.05.2018.
 */
public enum  Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;


    Dish(int i) {
this.duration = i;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){
        StringBuilder sb = new StringBuilder("");
        for(Enum e:Dish.values()){
            sb.append(e.toString()).append(", ");
        }
        return sb.toString().substring(0,sb.length()-2);
    }
}
/*1. Предположим, что нам известно время приготовления каждого блюда в минутах. Захардкодим его в классе Dish.
1.1. Измени создание элементов enum - Fish(25), Steak(30), Soup(15), Juice(5), Water(3);
1.2. Создай поле private int duration с геттером.
Чтобы создать геттер, нажмите Alt+Insert и выберите пункт Getter. Далее выберите имя поля и нажмите OK(Enter).*/