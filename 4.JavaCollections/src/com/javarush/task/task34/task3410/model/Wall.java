package com.javarush.task.task34.task3410.model;

import java.awt.*;

/**
 * Created by mr_ma on 18.04.2018.
 */
public class Wall extends  CollisionObject {
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.gray);
        graphics.drawRect(getX(),getY(),getWidth(),getHeight());
    }
}
