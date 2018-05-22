package com.javarush.task.task34.task3410.model;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mr_ma on 16.04.2018.
 */
public abstract class GameObject {
    private  int x;
    private int y;
    private int width;
    private int height;






    public GameObject(int x, int y) {
this.x = x;
        this.y = y;
        this.width = Model.FIELD_CELL_SIZE;
        this.height = Model.FIELD_CELL_SIZE;
    }
    public GameObject(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {

        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public abstract void draw(Graphics graphics);


}
/*2.2. 8.2.1. Поля Set<Wall> walls, Set<Box> boxes, Set<Home> homes и Player player.
8.2.2. Геттеры для этих полей.
8.2.3. Конструктор класса, принимающий Set<Wall> walls, Set <Box> boxes, Set<Home> homes, Player player и инициализирующий поля класса.
8.2.4. Метод Set<GameObject> getAll(). Он должен возвращать множество, содержащее все объекты, хранящиеся внутри класса.


Требования:
1. Создай класс GameObjects в пакте model.
2. Добавь в класс GameObjects поля Set walls, Set boxes, Set homes и Player player.
3. Добавь в класс GameObjects геттеры для полей.
4. Добавь в класс GameObjects конструктор класса, принимающий Set walls, Set boxes, Set homes, Player player и инициализирующий поля класса.
5. Добавь в класс GameObjects метод Set getAll(). Он должен возвращать множество, содержащее все объекты, хранящиеся внутри экземпляра класса.
*/