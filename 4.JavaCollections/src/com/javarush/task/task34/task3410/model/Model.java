package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by mr_ma on 13.04.2018.
 */
public class Model {
    private  GameObjects gameObjects;
    private  int currentLevel = 1;
    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private   LevelLoader levelLoader = new LevelLoader(Paths.get("..\\res\\levels.txt"));

    public void setEventListener(EventListener eventListener){
        this.eventListener=eventListener;
    }

    public  GameObjects getGameObjects(){
        return gameObjects;
    }

    public void   restartLevel(int level) throws IOException {
        gameObjects = levelLoader.getLevel(level);
    }

    public  void restart() throws IOException {
        restartLevel(currentLevel);
    }

    public  void  startNextLevel() throws IOException {
        restartLevel(++currentLevel);
    }



    public   boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        for(Wall w:getGameObjects().getWalls()){
           if (gameObject.isCollision(w,direction))
               return true;
        }
        return false;
    }

    public   boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction){
        Player player = gameObjects.getPlayer();
        GameObject stoped = null;
        for (GameObject gameObject : gameObjects.getAll()) {
            if (!(gameObject instanceof Player) && !(gameObject instanceof Home) && player.isCollision(gameObject, direction)) {
                stoped = gameObject;
            }
        }

        if ((stoped == null)) {
            return false;
        }

        if (stoped instanceof Box) {
            Box stopedBox = (Box) stoped;
            if (checkWallCollision(stopedBox, direction)) {
                return true;
            }
            for (Box box : gameObjects.getBoxes()) {
                if (stopedBox.isCollision(box, direction)) {
                    return true;
                }
            }

            switch (direction) {
                case LEFT:
                    stopedBox.move(-FIELD_CELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopedBox.move(FIELD_CELL_SIZE, 0);
                    break;
                case UP:
                    stopedBox.move(0, -FIELD_CELL_SIZE);
                    break;
                case DOWN:
                    stopedBox.move(0, FIELD_CELL_SIZE);
            }
        }
        return false;
    }

       /* Box movingBox=null;
        Player player = getGameObjects().getPlayer();
        if (checkWallCollision(player,direction)) return true;
        for(Box b:getGameObjects().getBoxes()){
            if (player.isCollision(b,direction)){
                if (checkWallCollision(b,direction))
                    return true;

                for(Box bbb:getGameObjects().getBoxes()){
                    if(b!=bbb&&b.isCollision(bbb,direction))
                        return  true;
                }

                movingBox=b;
            }


        }
        for (GameObject gameObject : gameObjects.getAll()) {
            if (!(gameObject instanceof Player) && !(gameObject instanceof Home) && player.isCollision(gameObject, direction)) {
                movingBox = (Box)gameObject;
            }
        }

        if ((movingBox == null)) {
            return false;
        }

        if (movingBox instanceof Box) {
            Box stopedBox = (Box) movingBox;
            if (checkWallCollision(stopedBox, direction)) {
                return true;
            }
            for (Box box : gameObjects.getBoxes()) {
                if (stopedBox.isCollision(box, direction)) {
                    return true;
                }
            }
        }
        if (movingBox!=null){
            if (direction==Direction.LEFT){
                movingBox.move(-FIELD_CELL_SIZE,0);
            } else  if (direction==Direction.RIGHT){
                movingBox.move(FIELD_CELL_SIZE,0);
            } else if (direction==Direction.UP){
                movingBox.move(0,-FIELD_CELL_SIZE);
            }
            else if (direction==Direction.DOWN){
                movingBox.move(0,FIELD_CELL_SIZE);
            }

        }
        return  false;
    }
         Player player = gameObjects.getPlayer();
        GameObject stoped = null;
        for (GameObject gameObject : gameObjects.getAll()) {
            if (!(gameObject instanceof Player) && !(gameObject instanceof Home) && player.isCollision(gameObject, direction)) {
                stoped = gameObject;
            }
        }

        if ((stoped == null)) {
            return false;
        }

        if (stoped instanceof Box) {
            Box stopedBox = (Box) stoped;
            if (checkWallCollision(stopedBox, direction)) {
                return true;
            }
            for (Box box : gameObjects.getBoxes()) {
                if (stopedBox.isCollision(box, direction)) {
                    return true;
                }
            }

            switch (direction) {
                case LEFT:
                    stopedBox.move(-FIELD_CELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopedBox.move(FIELD_CELL_SIZE, 0);
                    break;
                case UP:
                    stopedBox.move(0, -FIELD_CELL_SIZE);
                    break;
                case DOWN:
                    stopedBox.move(0, FIELD_CELL_SIZE);
            }
        }
        return false;*/

    public   void checkCompletion() throws IOException {
        int flag=0;
        for(Box b:getGameObjects().getBoxes()){
            for(Home h:getGameObjects().getHomes()){
                if (b.getY()==h.getY()&&b.getX()==h.getX()) {
                    flag++;
                    break;
                }

            }
        }
        if(flag==getGameObjects().getBoxes().size()&&flag==getGameObjects().getHomes().size()){
            eventListener.levelCompleted(currentLevel);
        }
    }

    public void move(Direction direction) throws IOException {
       /* Player player = getGameObjects().getPlayer();
        if (checkWallCollision(player,direction)||checkBoxCollisionAndMoveIAvaliable(direction))
            return;

        if (direction==Direction.LEFT){
            player.move(-FIELD_CELL_SIZE,0);
        } else  if (direction==Direction.RIGHT){
            player.move(FIELD_CELL_SIZE,0);
        } else if (direction==Direction.UP){
            player.move(0,-FIELD_CELL_SIZE);
        }
        else if (direction==Direction.DOWN){
            player.move(0,FIELD_CELL_SIZE);
        }

        checkCompletion();
*/
        Player player = gameObjects.getPlayer();

        if (checkWallCollision(player, direction)) {
            return;
        }
        if (checkBoxCollisionAndMoveIfAvaliable(direction)) {
            return;
        }

        switch (direction) {
            case LEFT:
                player.move(-FIELD_CELL_SIZE, 0);
                break;
            case RIGHT:
                player.move(FIELD_CELL_SIZE, 0);
                break;
            case UP:
                player.move(0, -FIELD_CELL_SIZE);
                break;
            case DOWN:
                player.move(0, FIELD_CELL_SIZE);
        }
        checkCompletion();
    }
}


/*Пришло время реализовать метод модели, отвечающий за движение move(), но для начала реализуем вспомогательные методы. Добавь в класс модели методы:
15.1. boolean checkWallCollision(CollisionObject gameObject, Direction direction). Этот метод проверяет столкновение со стеной.
Он должен вернуть true, если при движении объекта gameObject в направлении direction произойдет столкновение со стеной, иначе false.
Для определения столкновения используй метод isCollision() у игрового объекта.
15.2. boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction). Этот метод проверяет столкновение с ящиками. Метод должен:
15.2.1. Вернуть true, если игрок не может быть сдвинут в направлении direction (там находится: или ящик, за которым стена; или ящик за которым еще один ящик).
15.2.2. Вернуть false, если игрок может быть сдвинут в направлении direction (там находится: или свободная ячейка; или дом; или ящик, за которым
свободная ячейка или дом). При это, если на пути есть ящик, который может быть сдвинут, то необходимо переместить этот ящик на новые координаты.
Обрати внимание, что все объекты перемещаются на фиксированное значение FIELD_CELL_SIZE, независящее от размеров объекта, которые используются для его отрисовки.
Подсказка: для определения столкновений используй методы isCollision() игровых объектов и метод checkWallCollision() модели.
15.3. void checkCompletion(). Этот метод должен проверить пройден ли уровень (на всех ли домах стоят ящики, их координаты должны совпадать).
Если условие выполнено, то проинформировать слушателя событий, что текущий уровень завершен.
15.4. void move(Direction direction). Метод должен:
15.4.1. Проверить столкновение со стеной (метод checkWallCollision()), если есть столкновение - выйти из метода.
15.4.2. Проверить столкновение с ящиками (метод checkBoxCollisionAndMoveIfAvaliable()), если есть столкновение - выйти из метода.
15.4.3. Передвинуть игрока в направлении direction.
15.4.4. Проверить завершен ли уровень.

Запусти программу и проверь, что игрока можно перемещать, он может перемещать ящики, стены преграждают движение, а при перемещении всех ящиков в дома выводится сообщение о прохождении уровня.


Требования:
1. Реализуй в классе модели метод boolean checkWallCollision(CollisionObject gameObject, Direction direction).
2. Реализуй в классе модели метод boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction).
3. Реализуй в классе модели метод void checkCompletion().
4. Реализуй в классе модели метод void move(Direction direction).*/