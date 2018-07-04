package com.javarush.task.task35.task3513;

import java.awt.*;

/**
 * Created by mr_ma on 26.06.2018.
 */
public class Tile {
    int value;

    public Tile() {
        this.value=0;
    }

    public Tile(int value) {

        this.value = value;
    }

    public  boolean isEmpty(){
        if (value==0)
            return true;
        return false;
    }

    public Color getFontColor(){
        if (value<16)
            return new Color(0x776e65);
        return new Color(0xf9f6f2);
    }

    public  Color getTileColor(){
        switch (value){
            case 0:  return new Color(0xcdc1b4);
            case 2:  return new Color(0xeee4da);
            case 4:  return new Color(0xede0c8);
            case 8:  return new Color(0xf2b179);
            case 16:  return new Color(0xf59563);
            case 32:  return new Color(0xf67c5f);
            case 64:  return new Color(0xf65e3b);
            case 128:  return new Color(0xedcf72);
            case 256:  return new Color(0xedcc61);
            case 512:  return new Color(0xedc850);
            case 1024:  return new Color(0xedc53f);
            case 2048:  return new Color(0xedc22e);
            default: return new Color(0xff0000);
        }

    }
}
/*2048 (4)
Игра 2048 начинается на поле, где две плитки уже имеют какие-то начальные значения. А наше поле пока пусто :(.

Прежде чем бросаться писать код, давай подумаем как это можно было бы реализовать.

Предлагаю создать приватный метод addTile, который будет смотреть какие плитки пустуют и, если такие имеются,

менять вес одной из них, выбранной случайным образом, на 2 или 4 (на 9 двоек должна приходиться 1 четверка).

Получить случайный объект из списка можешь использовав следующее выражение:

(размерСписка * случайноеЧислоОтНуляДоЕдиницы).

Также получение свободных плиток можно вынести в отдельный приватный метод getEmptyTiles, возвращающий список

свободных плиток в массиве gameTiles.

После реализации функционала добавления новых плиток, добавим в конструктор два вызова метода addTile,

выполняя начальное условие задачи.

P.S. Пожалуй стоит весь код из конструктора переместить в метод resetGameTiles, для того, чтобы при необходимости

начать новую игру, не приходилось создавать новую модель, а можно было бы просто вернуться в начальное состояние

вызвав его. Уровень доступа должен быть шире приватного.

P.P.S. Для вычисления веса новой плитки используй выражение (Math.random() < 0.9 ? 2 : 4).


Требования:
1. Метод getEmptyTiles должен возвращать список пустых плиток в массиве gameTiles.
2. Метод addTile должен изменять значение случайной пустой плитки в массиве gameTiles на 2 или 4 с вероятностью 0.9 и 0.1 соответственно.
3. Метод resetGameTiles должен заполнять массив gameTiles новыми плитками и менять значение двух из них с помощью двух вызовов метода addTile.
4. В конструкторе класса Model должен содержаться вызов метода resetGameTiles.*/