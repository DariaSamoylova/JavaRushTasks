package com.javarush.task.task34.task3410.controller;

import com.javarush.task.task34.task3410.model.Direction;
import com.javarush.task.task34.task3410.model.GameObjects;
import com.javarush.task.task34.task3410.model.Model;
import com.javarush.task.task34.task3410.view.View;

import java.io.IOException;

/**
 * Created by mr_ma on 13.04.2018.
 */
public class Controller implements  EventListener {
   private View view ;
  private   Model model;

    public Controller( ) throws IOException {
        this.view = new View(this);
        view.setEventListener(this);
        this.model = new Model();
model.setEventListener(this);
        view.init();
        model.restart();

    }



    public  static  void main(String args[]) throws IOException {
        Controller controller = new Controller();

    }

    @Override
    public void move(Direction direction) throws IOException {
model.move(direction);
view.update();
    }

    @Override
    public void restart() throws IOException {
model.restart();
view.update();
    }

    @Override
    public void startNextLevel() throws IOException {
model.startNextLevel();
view.update();
    }

    @Override
    public void levelCompleted(int level) throws IOException {
view.completed(level);
    }

    public GameObjects getGameObjects(){
        return  model.getGameObjects();
    }


}
/*1Наполним контроллер функционалом.
13.1. Добавь в конструктор класса Controller к тому, что уже есть еще и установку
слушателя событий у модели и представления. Слушателем должен быть сам контроллер.
13.2. Реализуй методы контроллера:
13.2.1. move(Direction direction) - должен вызывать move(Direction direction) у модели
и update() у представления. Метода move() у модели еще нет, добавь для него
заглушку, мы его реализуем позже.
13.2.2. restart() - должен перезапускать модель и обновлять представление.
13.2.3. startNextLevel() - должен запускать у модели новый уровень и обновлять
представление.
13.3. Добавь в представление метод completed(int level), который будет сообщать
пользователю, что уровень level пройден. Метод должен:
13.3.1. Обновлять представление.
13.3.2. Показывать диалоговое окно с информацией о том, что пользователь прошел
какой-то уровень.
Подсказка: используй JOptionPane.showMessageDialog.
13.3.3. Просить контроллер запустить следующий уровень.
13.4. Реализуй в контроллере метод levelCompleted(int level), он должен вызвать
метод completed() у представления.*/