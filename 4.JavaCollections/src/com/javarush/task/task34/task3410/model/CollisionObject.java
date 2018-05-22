package com.javarush.task.task34.task3410.model;

/**
 * Created by mr_ma on 16.04.2018.
 */
public abstract class CollisionObject extends GameObject {
   // private int x,y;
    public CollisionObject(int x , int y) {
      super(x,y);
        //  this.x = x;
        //this.y = y;
    }

    public boolean isCollision(GameObject gameObject, Direction direction){
        int newX=getX();
        int newY = getY();
    /*    switch (direction.ordinal()){
            case 0:--newX;break;
            case 1:++newX;break;
            case 2:++newY;break;
            case 3:--newY;break;
                //    LEFT, RIGHT, UP , DOWN;
        }*/
        if (direction==Direction.LEFT){
            newX=newX-Model.FIELD_CELL_SIZE;
        } else  if (direction==Direction.RIGHT){
            newX=newX+Model.FIELD_CELL_SIZE;
        } else if (direction==Direction.UP){
            newY=newY-Model.FIELD_CELL_SIZE;
        }
        else if (direction==Direction.DOWN){
            newY=newY+Model.FIELD_CELL_SIZE;
        }

            return ((newX==gameObject.getX())&&newY==gameObject.getY());
    }
}
/*4.3.3.2. Метод boolean isCollision(GameObject gameObject, Direction direction).
Этот метод должен возвращаться true, если при перемещении текущего объекта в направлении direction на FIELD_CELL_SIZE произойдет столкновение с объектом gameObject, переданным в качестве параметра.
Иначе - возвращать false. Столкновением считать совпадение координат x и y.*/