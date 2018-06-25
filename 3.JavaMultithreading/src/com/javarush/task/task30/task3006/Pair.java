package com.javarush.task.task30.task3006;

public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x=%d, y=%d", x, y);
    }

    public void swap() {
x=x^y;
y=y^x;
x=x^y;
    }
}
/*Swap по-новому
В классе Pair реализуй метод swap, который должен для x, y менять местами их значения.
Можно использовать только операции:
1) Исключающее или. ^
2) Присваивание.=
3) Исключающее или с присваиванием.
Не оставляй комментарии, не меняй остальной код.
11000
11101


11111111
11100111



Требования:
1. В классе Pair должен присутствовать метод swap().
2. В классе Pair в методе swap() используй только разрешенные операции.
3. Вызов метода swap() должен поменять значения полей x и y.
4. Не изменяй никакой код, кроме метода swap().*/