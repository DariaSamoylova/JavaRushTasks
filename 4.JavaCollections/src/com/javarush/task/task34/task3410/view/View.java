package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.Controller;
import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.GameObjects;

import javax.swing.*;
import java.io.IOException;


public class View extends JFrame {
    private Controller controller;
    private Field field;


    public View(Controller controller) {
        this.controller = controller;
    }

    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Сокобан");
        setVisible(true);
    }


    public void setEventListener(EventListener eventListener){
        field.setEventListener(eventListener);
    }

    public  void  update(){
        field.repaint();
    }

    public GameObjects getGameObjects(){
        return  controller.getGameObjects();
    }

    public  void  completed(int level) throws IOException {
        update();
        JOptionPane.showMessageDialog(field,"пройден уровень "+level);
        controller.startNextLevel();
    }
}
/*13.3. Добавь в представление метод completed(int level), который будет сообщать
пользователю, что уровень level пройден. Метод должен:
13.3.1. Обновлять представление.
13.3.2. Показывать диалоговое окно с информацией о том, что пользователь прошел
какой-то уровень.
Подсказка: используй JOptionPane.showMessageDialog.
13.3.3. Просить контроллер запустить следующий уровень.
13.4. Реализуй в контроллере метод levelCompleted(int level), он должен вызвать
метод completed() у представления.*/