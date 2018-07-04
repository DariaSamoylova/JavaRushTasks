package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by mr_ma on 26.06.2018.
 */
public class Controller extends KeyAdapter {

   private Model model;
   private  View view;
   private static int WINNING_TILE = 2048;

    public Controller(Model model) {
        this.model = model;
        view = new View(this);
    }

    public   Tile[][] getGameTiles(){
       return model.getGameTiles();
    }

    public int getScore(){
        return  model.score;
    }

   public void resetGame(){
        model.score=0;
        view.isGameLost=false;
        view.isGameWon=false;
        model.resetGameTiles();
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if (e.getKeyCode()==KeyEvent.VK_ESCAPE)
           resetGame();
       if (!model.canMove())
           view.isGameLost=true;
       if(!view.isGameLost&&!view.isGameWon){
           if (e.getKeyCode()==KeyEvent.VK_LEFT)
               model.left();
           else  if (e.getKeyCode()==KeyEvent.VK_RIGHT)
               model.right();
           else  if (e.getKeyCode()==KeyEvent.VK_UP)
               model.up();
           else  if (e.getKeyCode()==KeyEvent.VK_DOWN)
               model.down();
           else  if (e.getKeyCode()==KeyEvent.VK_Z)
               model.rollback();
           else  if (e.getKeyCode()==KeyEvent.VK_R)
               model.randomMove();
           else  if (e.getKeyCode()==KeyEvent.VK_A)
               model.autoMove();

       }
       if(model.maxTile==WINNING_TILE)
           view.isGameWon=true;
       view.repaint();


    }

    public View getView() {
        return view;
    }
}
/*Кебе же, предстоит закончить реализацию класса Controller.

Также добавим в метод keyPressed класса Controller вызов метода rollback по нажатию на клавишу Z (код - KeyEvent.VK_Z).

Для начала нам понадобится конструктор, он будет принимать один параметр типа Model, инициализировать поле model, а также сохранять в поле view новый объект типа View
 с текущим контроллером(this) в качестве параметра конструктора.

Далее, нам нужен метод resetGame, который позволит вернуть игровое поле в начальное состояние. Необходимо обнулить счет, установить флаги isGameWon и isGameLost у представления в false
и вызывать метод resetGameTiles у модели.

Примечание: устанавливай значение полей напрямую, без использования сеттеров.
Добавим приватную константу int WINNING_TILE = 2048. Она будет определять вес плитки при достижении которого игра будет считаться выигранной.

Ну а теперь, самое главное! Для того чтобы иметь возможность обрабатывать пользовательский ввод, необходимо переопределить метод keyPressed с одним параметром типа KeyEvent.

Логика метода должна быть следующей:
1. Если была нажата клавиша ESC - вызови метод resetGame.
2. Если метод canMove модели возвращает false - установи флаг isGameLost в true.
3. Если оба флага isGameLost и isGameWon равны false - обработай варианты движения:
а) для клавиши KeyEvent.VK_LEFT вызови метод left у модели;
б) для клавиши KeyEvent.VK_RIGHT вызови метод right у модели;
в) для клавиши KeyEvent.VK_UP вызови метод up у модели;
г) для клавиши KeyEvent.VK_DOWN вызови метод down у модели.
4. Если поле maxTile у модели стало равно WINNING_TILE, установи флаг isGameWon в true.
5. В самом конце, вызови метод repaint у view.

P.S. Для получения кода нажатой клавиши используй метод getKeyCode класса KeyEvent.


Требования:
1. В классе Controller должна быть создана приватная статическая константа int WINNING_TILE = 2048.
2. Конструктор класса Controller с одним параметром типа Model должен быть реализован в соответствии с условием задачи.
3. Метод resetGame должен возвращать игру в начальное состояние, как описано в условии задачи.
4. Метод keyPressed должен вызывать метод resetGame в случае, если была нажата клавиша ESC.
5. Метод keyPressed должен устанавливать флаг isGameLost в true в случае, если ход невозможен.
6. Метод keyPressed должен вызывать корректные методы перемещения игрового поля, в случае если была нажата подходящая клавиша и оба флага isGameLost и isGameWon равны false.
7. Метод keyPressed должен устанавливать флаг isGameWon равным true в случае, если значения полей model.maxTile и WINNING_TILE стали равны после передвижения.
8. Метод keyPressed должен вызывать метод repaint у объекта сохраненного в поле view.*/