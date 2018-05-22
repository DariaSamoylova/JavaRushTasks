package com.javarush.task.task23.task2312;

public class SnakeSection {
    private int x;
    private int y;


    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = 31 * result + x;
        result = 31 * result + y ;

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        return true;
        if (obj == null)
            return false;
      //  if (!(obj instanceof Solution))
         //   return false;
        if (getClass() != obj.getClass())
            return false;
        SnakeSection other = (SnakeSection) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;

    }


    public int getY() {
        return y;
    }
}
/*Змейка(16)
Ничто не вечно. Так и змея должна умирать, если она врезается в стену или саму себя.

Для определения, не пересекается ли змея сама с собой, можно сделать очень простую проверку:
содержит ли список sections «новую голову змеи«.

Код для этого будет выглядеть примерно так:
if (sections.contains(head))

При этом head должен быть еще не добавлен в список sections, иначе будет всегда true.
Но чтобы этот код работал, надо реализовать методы сравнения объектов (equals и hashCode) в классе SnakeSection.

Подсказка:
Используй Ctrl+O в Intellij IDEA для автоматической генерации методов equals и hashCode.

Задание:
а) реализуй методы equals и hashCode в классе SnakeSection.
б) реализуй метод checkBorders(SnakeSection head): если голова змеи за границами комнаты — змея умирает (isAlive = false)
в) реализуй метод checkBody(SnakeSection head): если голова змеи пересекается с ее телом — змея умирает (isAlive = false)


Требования:
1. В классе SnakeSection должен быть метод equals.
2. В классе SnakeSection должен быть метод hashCode.
3. В классе Snake должен быть реализован, в соответствии с условием, метод checkBorders.
4. В классе Snake должен быть реализован, в соответствии с условием, метод checkBody.*/