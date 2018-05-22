package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.Direction;
import com.javarush.task.task34.task3410.model.GameObject;
import com.javarush.task.task34.task3410.model.GameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Created by mr_ma on 16.04.2018.
 */
public class Field extends JPanel {
    private  View view;
    private EventListener eventListener;
    public Field(View view) {
        this.view = view;
        KeyHandler keyHandler = new KeyHandler();
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

    }
    public  void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(20,20,20,20);
        GameObjects gameObjects= view.getGameObjects();
       for(GameObject ob: gameObjects.getAll()){
           ob.draw(g);
       }

    }

    public void setEventListener(EventListener eventListener){
        this.eventListener=eventListener;
    }

     /*  class  KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
           // super.keyPressed(e);
            if (KeyEvent.VK_LEFT==e.getKeyCode()){
                eventListener.move(Direction.LEFT);
            }
           else if (KeyEvent.VK_RIGHT==e.getKeyCode()){
                eventListener.move(Direction.RIGHT);
            }
            else if (KeyEvent.VK_UP==e.getKeyCode()){
                eventListener.move(Direction.UP);
            }
            else  if (KeyEvent.VK_DOWN==e.getKeyCode()){
                eventListener.move(Direction.DOWN);
            }
            else if (KeyEvent.VK_R==e.getKeyCode()){
                eventListener.restart();
            }
        }
    }*/
     public class KeyHandler extends KeyAdapter {



         @Override
         public void keyPressed(KeyEvent e) {
             try {
             switch (e.getKeyCode()) {
                 case (KeyEvent.VK_LEFT):
                     eventListener.move(Direction.LEFT);
                     break;
                 case (KeyEvent.VK_RIGHT):
                     eventListener.move(Direction.RIGHT);
                     break;
                 case (KeyEvent.VK_UP):
                     eventListener.move(Direction.UP);
                     break;
                 case (KeyEvent.VK_DOWN):
                     eventListener.move(Direction.DOWN);
                     break;
                 case (KeyEvent.VK_R):

                         eventListener.restart();

                     break;
             }
             } catch (IOException e1) {
                 e1.printStackTrace();
             }
         }
}}
/*4.1. Добавь в класс Field вложенный класс KeyHandler унаследованный от KeyAdapter.
14.2. Перегрузи у него метод keyPressed(). Если была нажата клавиша с кодом VK_LEFT, то пошли eventListener-у событие move с параметром Direction.LEFT.
Аналогичным образом обработай нажатия клавиш с кодом VK_RIGHT, VK_UP и VK_DOWN. Если пользователь нажал клавишу R с кодом VK_R, то вызови у слушателя событий метод restart().
14.3. В конструкторе класса Field:
14.3.1. Создай объект класса KeyHandler.
14.3.2. Добавь его слушателем с помощью метода addKeyListener().
14.3.3. Установи focusable в true (метод setFocusable()).*/