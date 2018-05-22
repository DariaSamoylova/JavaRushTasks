package com.javarush.task.task37.task3712;

/**
 * Created by mr_ma on 28.02.2018.
 */
public abstract  class Game {
    public abstract void prepareForTheGame() ;

    public abstract void playGame();

    public abstract void congratulateWinner();
    public   void run(){
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }
}
