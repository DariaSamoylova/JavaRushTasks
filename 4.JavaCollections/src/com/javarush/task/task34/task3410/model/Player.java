package com.javarush.task.task34.task3410.model;

import java.awt.*;

/**
 * Created by mr_ma on 17.04.2018.
 */
public class Player extends  CollisionObject  implements  Movable {
    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.yellow);
        graphics.drawOval(getX(),getY(),getWidth(),getHeight());

    }

    @Override
    public void move(int x, int y) {
        setX(x+getX());
        setY(y+getY());
    }
}