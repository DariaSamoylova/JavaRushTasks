package com.javarush.task.task34.task3410.model;

import java.awt.*;

/**
 * Created by mr_ma on 18.04.2018.
 */
public class Home extends  GameObject {
    public Home(int x, int y) {
        super(x, y, 2, 2);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.drawOval(getX(),getY(),getWidth(),getHeight());
    }
}
