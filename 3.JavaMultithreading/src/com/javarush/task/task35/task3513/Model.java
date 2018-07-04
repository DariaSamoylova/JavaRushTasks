package com.javarush.task.task35.task3513;

import java.util.*;

/**
 * Created by mr_ma on 26.06.2018.
 */
public class Model {
    private final  static int FIELD_WIDTH = 4;
private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;
    private boolean   isSaveNeeded = true;


    private   Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    int score;
    int maxTile;

    public Model() {
        resetGameTiles();
        score=0;
        maxTile=0;
        previousStates = new Stack();
        previousScores = new Stack();

    }
    public Tile[][] getGameTiles() {
        return gameTiles;
    }
    private  void addTile(){
        List<Tile> tiles =getEmptyTiles();
        if (!tiles.isEmpty()) {
            Tile newTile = tiles.get((int) (tiles.size() * Math.random()));
            newTile.value = (Math.random() < 0.9 ? 2 : 4);
        }
    }

    private List<Tile> getEmptyTiles(){
        List<Tile> result = new ArrayList();
        for(int i=0;i<FIELD_WIDTH;i++){
            for(int j =0;j<FIELD_WIDTH;j++){
               if (gameTiles[i][j].isEmpty())
                   result.add(gameTiles[i][j]);
            }
        }
        return result;
    }

    public  void resetGameTiles(){
        for(int i=0;i<FIELD_WIDTH;i++){
            for(int j =0;j<FIELD_WIDTH;j++){
                gameTiles[i][j]=new Tile();
            }
        }
        addTile();
        addTile();
    }

    private  boolean  compressTiles(Tile[] tiles) {
        Tile swap;
        boolean isChanged=false;
        for (int j = 0; j < tiles.length - 1; j++) {
            for (int i = 0; i < tiles.length - 1; i++) {
                if (tiles[i].value == 0&& tiles[i + 1].value != 0) {
                    swap = tiles[i];
                    tiles[i] = tiles[i + 1];
                    tiles[i + 1] = swap;
                    isChanged=true;
                }
            }
        }
        return isChanged;

    }


    private  boolean mergeTiles(Tile[] tiles){
        boolean isChanged=false;
        for(int i=0;i<tiles.length-1;i++) {
            if (tiles[i].value!=0&&tiles[i].value == tiles[i+1].value ) {
                tiles[i].value=tiles[i].value+tiles[i].value;
                score=score+ tiles[i].value;
                if ( tiles[i].value>maxTile){
                    maxTile= tiles[i].value;
                }


                tiles[i+1].value=0;
                compressTiles(tiles);
                isChanged=true;
            }
        }
        return isChanged;

    }

    public void left(){
if (isSaveNeeded){
    saveState(gameTiles);
}

        boolean isChanged=false;
        for(int i=0;i<FIELD_WIDTH;i++){
           if( compressTiles(gameTiles[i])|mergeTiles(gameTiles[i]))
               isChanged= true;

        }
        if (isChanged){
         addTile();}
        isSaveNeeded = true;
    }
    /*2. В методе left организуем проверку того, вызывался ли уже метод saveState. За это у нас отвечает флаг isSaveNeeded, соответственно, если он равен true, выполняем сохранение.
 После выполнения сдвига влево устанавливаем флаг isSaveNeeded равным true.*/

    public void right(){
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void up(){
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public void down(){
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }
    private void rotate(){

        Tile[][] newGameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for(int i=0;i<FIELD_WIDTH;i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                newGameTiles[i][j]=gameTiles[FIELD_WIDTH-j-1][i];
            }
        }
        gameTiles=newGameTiles;
    }

    public    boolean canMove(){

        if (!getEmptyTiles().isEmpty())
            return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j-1].value)
                    return true;
            }
        }
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[j][i].value == gameTiles[j-1][i]. value)return true;
            }
        }
        return false;
    }

    private  void saveState(Tile[][] tiles){
        Tile[][] tilesNew =  new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                tilesNew[i][j] =new Tile( tiles[i][j].value);
            }
        }
        previousScores.push(score);
        previousStates.push(tilesNew);
        isSaveNeeded = false;
    }

    public  void rollback(){
        if(!previousScores.empty())
             score = previousScores.pop();

        if(!previousStates.empty() )
             gameTiles = previousStates.pop();
    }

    public  void randomMove(){
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n){
            case 0:left();break;
            case 1:right();break;
            case 2:up();break;
            case 3:down();break;
        }
    }

    public  boolean hasBoardChanged(){
        Tile[][] tilesNew = previousStates.peek();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
               if (tilesNew[i][j].value!=gameTiles[i][j].value)
                   return true;
            }
        }
        return  false;
    }
    public   MoveEfficiency getMoveEfficiency(Move move){
        MoveEfficiency moveEfficiency=null;
        move.move();
        if (!hasBoardChanged()){
            moveEfficiency = new MoveEfficiency(-1,0,move);
        } else {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score,  move);
        }
        rollback();
        return  moveEfficiency;
    }

    public  void autoMove(){
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue(4,Collections.reverseOrder() );
        priorityQueue.offer(getMoveEfficiency(  ()->right()));
        priorityQueue.offer( getMoveEfficiency( ()->left()));
        priorityQueue.offer(getMoveEfficiency( ()->up()));
        priorityQueue.offer(getMoveEfficiency( ()->down()));
        priorityQueue.poll().getMove().move();
    }
}
/*2Осталось совсем немного! У нас есть способ вычислить эффективность любого хода, а также мы можем их сравнивать между собой.

Давай реализуем метод autoMove в классе Model, который будет выбирать лучший из возможных ходов и выполнять его.

Сделаем так:
1) Создадим локальную PriorityQueue с параметром Collections.reverseOrder() (для того, чтобы вверху очереди всегда был максимальный элемент) и размером равным четырем.
2) Заполним PriorityQueue четырьмя объектами типа MoveEfficiency (по одному на каждый вариант хода).
3) Возьмем верхний элемент и выполним ход связанный с ним.

После реализации метода autoMove добавим его вызов в метод keyPressed класса Controller по нажатию на клавишу A (код - KeyEvent.VK_A).

P.S. В качестве факультативного задания можешь почитать про указатели на методы и попробовать передать аргумент в метод getMoveEfficiency используя оператор "::".
Для метода left должно получиться getMoveEfficiency(this::left). Альтернативно можешь использовать внутренний анонимный класс.


Требования:
1. В методе autoMove должен быть создан объект типа PriorityQueue с размером равным четырем.
2. В методе autoMove в PriorityQueue должно быть добавлено 4 объекта типа MoveEfficiency с помощью метода offer (по одному на каждый вариант хода).
3. Метод keyPressed класса Controller должен вызывать метод autoMove у модели в случае, если была нажата клавиша с кодом KeyEvent.VK_A.
4. В методе autoMove должен быть выполнен метод move связанный с объектом MoveEfficiency полученном с помощью метода peek или poll.

*/