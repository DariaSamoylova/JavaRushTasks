package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr_ma on 25.10.2017.
 */
public class Snake {
  private  ArrayList<SnakeSection> sections;
    private  boolean isAlive;
    private  SnakeDirection direction;

    public Snake(int x,int y){
        sections=new ArrayList<>();
        SnakeSection s = new SnakeSection(x,y);
        sections.add(s);
        isAlive=true;
    }
    
      int getX(){
        return sections.get(0).getX();
    }

      int getY(){
        return sections.get(0).getY();
    }

    public void move() {
        if (!isAlive) return;
        if (direction==SnakeDirection.UP){
            move(0,-1);
        }else  if (direction==SnakeDirection.RIGHT){
            move(1,0);
        }else  if (direction==SnakeDirection.DOWN){
            move(0,1);
        }else  if (direction==SnakeDirection.LEFT){
            move(-1,0);
        }
    }

    public void move(int x, int y) {

        //Создаем новую голову - новый "кусочек змеи".

        SnakeSection head = sections.get(0);

        head = new SnakeSection(head.getX() + x, head.getY() + x);



        //Проверяем - не вылезла ли голова за границу комнаты

        checkBorders(head);

        if (!isAlive) return;



        //Проверяем - не пересекает ли змея  саму себя

        checkBody(head);

        if (!isAlive) return;



        //Проверяем - не съела ли змея мышь.

        Mouse mouse = Room.game.getMouse();

        if (head.getX() == mouse.getX() && head.getY() == mouse.getY()) //съела

        {

            sections.add(0, head);                  //Добавили новую голову

            Room.game.eatMouse();                   //Хвот не удаляем, но создаем новую мышь.

        }

        else //просто движется

        {

            sections.add(0, head);                  //добавили новую голову

            sections.remove(sections.size() - 1);   //удалили последний элемент с хвоста

        }

    }
    /*{
      //  int    xx = sections.get(0).getX();
     //   int    yy = sections.get(0).getY();
        int   xx=this.getX();
        int   yy=this.getY();
        SnakeSection n = new SnakeSection(xx + x, yy + y);
        checkBorders(n);
        checkBody(n);
      //  int xx=0,yy=0;
       if (this.isAlive()) {
            sections.add(0, n);



if (xx==Room.game.getMouse().getX()&&yy==Room.game.getMouse().getY()) {
    Room.game.eatMouse();
  //  sections.add(0, n);

} else {
    //sections.add(0, n);
    sections.remove(sections.size() - 1);
}
         }
    }*/


    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

   /* public ArrayList<SnakeSection> getSections() {

        return this.sections;
    }*/
    public ArrayList<SnakeSection> getSections()

    {

        return sections;

    }
/*private ArrayList < SnakeSection > sections; public ArrayList < SnakeSection > getSections(){ return this.sections; }*/
    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    /* public void checkBorders(SnakeSection head) {
       if (getX()<0||getY()<0||getX()>Room.game.getWidth()||getY()>Room.game.getHeight())
            isAlive = false;
    }

    public void checkBody(SnakeSection head){

        if (sections.contains(head))
            isAlive = false;
    }*/
        /**

         *  Метод проверяет - находится ли новая голова в пределах комнаты

         */

        private void checkBorders(SnakeSection head)
        {

            if ((head.getX() < 0 || head.getX() >= Room.game.getWidth()) || head.getY() < 0 || head.getY() >= Room.game.getHeight())

            {

                isAlive = false;

            }

        }


        /**

         *  Метод проверяет - не совпадает ли голова с каким-нибудь участком тела змеи.

         */

    private void checkBody(SnakeSection head)

    {

        if (sections.contains(head))

        {

            isAlive = false;

        }

    }

}
/*Теперь закончим класс Snake.

Змея состоит из кусочков. Давай каждый ход просто добавлять один кусочек со стороны головы,
а самый последний — удалять. Тогда получится, что змея ползет.
Добавлять кусочек нужно рядом с текущей головой (кусочком номер 0).
С какой стороны добавлять зависит от direction (UP, DOWN, LEFT, RIGHT).

Подсказка:
а) Как добавить кусочек змеи в начало списка sections?
sections.add(0, new_section);
б) А как удалить последний?
sections.remove(sections.size()-1);

Необходимо реализовать метод move(int dx, int dy):
а) проверить, не вылезла ли она за границу комнаты (если да, то змея умирает)
б) проверить, не совпадает ли она с уже существующими кусочками змеи (если да, то змея умирает)
в) добавить голову к змее (со стороны головы) и удалить последний кусочек из хвоста.
г) вызвать метод eatMouse у статического объекта game класса Room, если координаты мыши совпадают с координатами головы змеи.
д) если змея поймала мышь (координаты головы совпадают с координатами мыши), то удалять кусок из хвоста не надо.


Требования:
1. В методе move(int dx, int dy) должен быть вызван метод checkBorders.
2. В методе move(int dx, int dy) должен быть вызван метод checkBody.
3. В случае если змея осталась жива, необходимо добавить голову и удалить последний элемент из хвоста змеи.
4. В случае, если змея поймала мышь, необходимо добавить голову, но последний элемент удалять не нужно.
5. Необходимо вызвать метод eatMouse у статического объекта game класса Room, если координаты мыши совпадают с координатами головы змеи.*/