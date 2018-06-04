package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr_ma on 24.05.2018.
 */
public class ConsoleHelper {
   private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public  static void writeMessage(String message){
        System.out.println(message);
    }

    public  static  String readString() throws IOException {
        return in.readLine();
    }

    public  static   List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> allDishes = new ArrayList<>();
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        while (true) {
            ConsoleHelper.writeMessage("введи название блюда");
          //  try {
                String answer = ConsoleHelper.readString();
                if (answer.equals("exit")){
                    break;
                }
                if (!Dish.allDishesToString().contains(answer)){
                    ConsoleHelper.writeMessage("такого блюда нет");
                } else{
                    allDishes.add(Dish.valueOf(answer));
                }

          //  } catch (IOException e) {
                // e.printStackTrace();
          //      logger.log(Level.SEVERE,"Console is unavailable.");
           // }
        }
return  allDishes;
    }
}
/*- writeMessage(String message) - для вывода message в консоль
- String readString() - для чтения строки с консоли
- List<Dish> getAllDishesForOrder() - просит пользователя выбрать блюдо и добавляет его в список.
Выведи список всех блюд и попроси пользователя ввести строку - название блюда.
Введенное 'exit' означает завершение заказа.
В случае, если введенное блюдо не представлено в меню, выведи сообщение о том, что такого блюда нет и продолжи формирование заказа.
Исключения ввода-вывода бросай выше, на этом уровне не понятно, что с ними делать.*/