package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
все работает
*/
public class CustomTree extends AbstractList<String> implements Cloneable,Serializable {
     Entry<String> root=new Entry<String>("0");
//ArrayList<Entry> allElem = new ArrayList<>();
    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
           // System.out.print("was added "+i+"             ");
            list.add(String.valueOf(i));

        }
    //   System.out.println(list.size());
       //for (int i = 1; i < 16; i++) {
     //       System.out.println("parent of " +i+"==="+ ((CustomTree) list).getParent(String.valueOf(i)));
    //   }
       System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
         list.remove("5");
         System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
        ////for (int i = 1; i < 16; i++) {
      //       System.out.println("parent of " +i+"==="+ ((CustomTree) list).getParent(String.valueOf(i)));
      //   }
       //  System.out.println(list.size());
    }


    public String get(int index) {
        throw new UnsupportedOperationException();
    }
    public List<String> subList(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
    protected void removeRange(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
    public boolean addAll(int index, Collection<? extends String> c){
        throw new UnsupportedOperationException();
    }
    public String set(int index, String element){
        throw new UnsupportedOperationException();
    }
    public void add(int index, String element){
        throw new UnsupportedOperationException();
    }
    public String remove(int index){
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements  Serializable{
         String elementName;
         int lineNumber;
         boolean availableToAddLeftChildren, availableToAddRightChildren;
         Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren=true;
            availableToAddRightChildren=true;
        }
        void checkChildren(){
            if (leftChild!=null){
                availableToAddLeftChildren=false;
            }
            if (rightChild!=null){
                availableToAddRightChildren=false;
            }
        }

        boolean isAvailableToAddChildren(){
            return  (availableToAddLeftChildren||availableToAddRightChildren);
        }
    }

    @Override
    public boolean add(String s){
        Entry<String> newElem = new Entry<>(s);
      //  int line=1;
        Entry<String> upperElem=root;
        Entry<String> currElem;
       // Entry<String> firstLeftElem=root;
       // Stack<Entry> elemTree = new Stack<>();
        Queue<Entry> elemTree = new ArrayDeque<>();
        while(true){
            if(upperElem.isAvailableToAddChildren()){
                newElem.parent=upperElem;
                if (upperElem.availableToAddLeftChildren){
                   upperElem.leftChild=newElem;

                } else {
                    upperElem.rightChild=newElem;
                }
                upperElem.checkChildren();
              //  allElem.add(newElem);
               // newElem.lineNumber=line;
              //  System.out.println("parent="+upperElem.elementName);
                break;
            }
            else{
                if (elemTree.isEmpty()){

                    elemTree.add(upperElem.rightChild);
                    upperElem=upperElem.leftChild;
                   // if (Integer.parseInt(s)==(Math.pow(2,line)-1))
                   //     firstLeftElem=upperElem;
                   // line++;

                }
                else{
                    currElem=upperElem;
                    upperElem=elemTree.poll();
                    if (!currElem.availableToAddLeftChildren){
                        elemTree.add(currElem.leftChild);
                    }
                    if (!currElem.availableToAddRightChildren){
                        elemTree.add(currElem.rightChild);
                    }


                    }
                }
            }

       return true;
    }
  @Override
    public boolean remove(Object o){
 //       if (!(o instanceof Entry)){
  //          return false;
  //      }
        Entry<String> searchElem=getElem(String.valueOf( o));

      //  String s = searchElem.elementName;
        Entry<String> upperElem = searchElem;
        ArrayList<Entry> allDeletedElem = new ArrayList<>();
       Stack<Entry> elemTree = new Stack<>();
   //   Queue<Entry> elemTree = new ArrayDeque<>();
//        boolean flag;
        allDeletedElem.add(searchElem);
      while(true){
          if( upperElem.availableToAddLeftChildren&& upperElem.availableToAddRightChildren){
              if (elemTree.empty()) {
                  allDeletedElem.add(upperElem);
                  break;
              } else {

                  upperElem=elemTree.pop();
                  // elemTree.pop();
                  continue;
              }
          } else if (upperElem.availableToAddRightChildren&&!upperElem.availableToAddLeftChildren){
              upperElem=upperElem.leftChild;
              allDeletedElem.add(upperElem);
              continue;

          } else if (upperElem.availableToAddLeftChildren&&!upperElem.availableToAddRightChildren){
              upperElem=upperElem.rightChild;
              allDeletedElem.add(upperElem);
              continue;
          }
          else if  (!upperElem.availableToAddLeftChildren&&!upperElem.availableToAddRightChildren){
            //  allDeletedElem.add(upperElem.rightChild);
              allDeletedElem.add(upperElem.leftChild);
              elemTree.push(upperElem.rightChild);
              upperElem=upperElem.leftChild;
              continue;
          }
      }
      for(Entry<String> eee:allDeletedElem){
        //  System.out.println("element="+eee.elementName);
          if (eee.parent!=null&& eee.parent.leftChild!=null&&(eee.parent.leftChild.elementName).equals(eee.elementName)){
              eee.parent.leftChild=null;
              eee.parent.checkChildren();
          } else if (eee.parent!=null&&eee.parent.rightChild!=null&& (eee.parent.rightChild.elementName).equals(eee.elementName)){
              eee.parent.rightChild=null;
              eee.parent.checkChildren();
          }
          eee.parent=null;
          eee.leftChild=null;
          eee.rightChild=null;
          eee.checkChildren();
      }
          return true;
     }
    @Override
    public int size() {
        int count=0;
        Entry<String> upperElem=root;

        Stack<Entry> elemTree = new Stack<>();
        while(true){
           if( upperElem.availableToAddLeftChildren&& upperElem.availableToAddRightChildren){
               if (elemTree.empty()) {
                   return count;
               } else {

                   upperElem=elemTree.pop();
                  // elemTree.pop();
                   continue;
               }
           } else if (upperElem.availableToAddRightChildren&&!upperElem.availableToAddLeftChildren){
               upperElem=upperElem.leftChild;
               count++;
               continue;

           } else if (upperElem.availableToAddLeftChildren&&!upperElem.availableToAddRightChildren){
                upperElem=upperElem.rightChild;
                count++;
                continue;
            }
             else if  (!upperElem.availableToAddLeftChildren&&!upperElem.availableToAddRightChildren){

                count=count+2;
               elemTree.push(upperElem.rightChild);
               upperElem=upperElem.leftChild;
               continue;
            }
        }

    }
/* Queue<File> fileTree = new PriorityQueue<>();

        Collections.addAll(fileTree, rootDir.listFiles());

        while (!fileTree.isEmpty())
        {
            File currentFile = fileTree.remove();
            if(currentFile.isDirectory()){
                Collections.addAll(fileTree, currentFile.listFiles());
            } else {
                result.add(currentFile.getAbsolutePath());
            }
        }*/


    public String getParent(String s) {
        Entry<String> upperElem = root;

        Stack<Entry> elemTree = new Stack<>();
        while (true) {
            if (upperElem.elementName.equals(s)) return upperElem.parent.elementName;

            if (upperElem.availableToAddLeftChildren && upperElem.availableToAddRightChildren) {
                if (elemTree.empty()) {
                    return null;
                } else {

                    upperElem = elemTree.pop();
                    // elemTree.pop();
                    continue;
                }
            } else if (upperElem.availableToAddRightChildren && !upperElem.availableToAddLeftChildren) {
                upperElem = upperElem.leftChild;

                continue;

            } else if (upperElem.availableToAddLeftChildren && !upperElem.availableToAddRightChildren) {
                upperElem = upperElem.rightChild;

                continue;
            } else if (!upperElem.availableToAddLeftChildren && !upperElem.availableToAddRightChildren) {


                elemTree.push(upperElem.rightChild);
                upperElem = upperElem.leftChild;
                continue;
            }

        }
    }

    public Entry getElem (String s) {
        Entry<String> upperElem = root;

        Stack<Entry> elemTree = new Stack<>();
        while (true) {
            if (upperElem.elementName.equals(s)) return upperElem;

            if (upperElem.availableToAddLeftChildren && upperElem.availableToAddRightChildren) {
                if (elemTree.empty()) {
                    return null;
                } else {

                    upperElem = elemTree.pop();
                    // elemTree.pop();
                    continue;
                }
            } else if (upperElem.availableToAddRightChildren && !upperElem.availableToAddLeftChildren) {
                upperElem = upperElem.leftChild;

                continue;

            } else if (upperElem.availableToAddLeftChildren && !upperElem.availableToAddRightChildren) {
                upperElem = upperElem.rightChild;

                continue;
            } else if (!upperElem.availableToAddLeftChildren && !upperElem.availableToAddRightChildren) {


                elemTree.push(upperElem.rightChild);
                upperElem = upperElem.leftChild;
                continue;
            }

        }
    }
}
/*Построй дерево(2)
Построй дерево(4)
Итак, основа дерева создана, пора тебе поработать немного самому.
Вспомним как должно выглядеть наше дерево.

Элементы дерева должны следовать так как показано на картинке:
http://info.javarush.ru/uploads/images/00/04/89/2014/03/21/ee9a9b.jpg

Необходимо написать методы, которые бы позволили создать такую структуру дерева и проводить операции над ней.

Тебе необходимо реализовать:
1. метод add(String s) - добавляет элементы дерева, в качестве параметра принимает имя элемента (elementName), искать место для вставки начинаем слева направо.
2. метод remove(Object o) - удаляет элемент дерева имя которого было полученного в качестве параметра.
3. метод size() - возвращает текущее количество элементов в дереве.
4. метод getParent(String s) - возвращает имя родителя элемента дерева, имя которого было полученного в качестве параметра.


Требования:
1. После добавления N элементов в дерево с помощью метода add, метод size должен возвращать N.
2. После удаления последнего добавленного элемента из дерева с помощью метода remove, метод size должен возвращать N-1.
3. После удаления второго элемента добавленного в дерево, метод size должен возвращать N/2 + 1 (для случаев где N > 2 и является степенью двойки), N - размер дерева до удаления.
4. Метод getParent должен возвращать имя родителя для любого элемента дерева.
*/