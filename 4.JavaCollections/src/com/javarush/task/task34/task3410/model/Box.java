package com.javarush.task.task34.task3410.model;

import java.awt.*;

/**
 * Created by mr_ma on 17.04.2018.
 */
public class Box extends  CollisionObject implements  Movable {
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
       
        graphics.setColor(Color.orange);
        graphics.drawRect(getX(),getY(),getWidth(),getHeight());
    }

    @Override
    public void move(int x, int y) {
        setX(x+getX());
        setY(y+getY());
    }
}
/*5.5. В каждом из них, реализуй метод, отвечающий за отрисовку. Этот метод должен: устанавливать какой-то цвет и рисовать какие-то примитивные фигуры. Проследи, чтобы центр фигуры имел координаты x и y,
а высота и ширина соответствовали
значениям полей height и width.

Подсказка: игрока можешь нарисовать желтым залитым кругом, а ящик - оранжевым квадратом с прорисованными диагоналями. Это пример, ты можешь сам выбрать цвет и вид каждого объекта, ты ограничен только
 методами доступными для Graphics и своей фантазией.

Для того чтобы проверить как рисуется твой ящик или игрок, ты можешь создать объект типа Box или Player в методе paint() класса Field и вызвать у объекта метод draw(). Сделай это исключительно
для проверки методов draw(), в дальнейшем метод
paint() мы реализуем иначе.*/