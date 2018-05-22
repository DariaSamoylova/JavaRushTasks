package com.javarush.task.task28.task2805;



/**
 * Created by mr_ma on 06.05.2018.
 */
public class MyThread extends Thread {
    static int prior=1;
    public MyThread() {



        if (this.getThreadGroup()!=null){
            this.setPriority(prior>this.getThreadGroup().getMaxPriority()?this.getThreadGroup().getMaxPriority():prior);
        } else
            this.setPriority(prior);

        if(prior==10){

            prior=1;}
        else {
            prior++;
        }

    }

    public MyThread(Runnable target) {
        super(target);
        if (this.getThreadGroup()!=null){
            this.setPriority(prior>this.getThreadGroup().getMaxPriority()?this.getThreadGroup().getMaxPriority():prior);
        } else
            this.setPriority(prior);

        if(prior==10){

            prior=1;}
        else {
            prior++;
        }
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (this.getThreadGroup()!=null){
            this.setPriority(prior>this.getThreadGroup().getMaxPriority()?this.getThreadGroup().getMaxPriority():prior);
        } else
            this.setPriority(prior);

        if(prior==10){

            prior=1;}
        else {
            prior++;
        }
    }

    public MyThread(String name) {
        super(name);
        if (this.getThreadGroup()!=null){
            this.setPriority(prior>this.getThreadGroup().getMaxPriority()?this.getThreadGroup().getMaxPriority():prior);
        } else
            this.setPriority(prior);

        if(prior==10){

            prior=1;}
        else {
            prior++;
        }
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (this.getThreadGroup()!=null){
            this.setPriority(prior>this.getThreadGroup().getMaxPriority()?this.getThreadGroup().getMaxPriority():prior);
        } else
            this.setPriority(prior);

        if(prior==10){

            prior=1;}
        else {
            prior++;
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if (this.getThreadGroup()!=null){
            this.setPriority(prior>this.getThreadGroup().getMaxPriority()?this.getThreadGroup().getMaxPriority():prior);
        } else
            this.setPriority(prior);

        if(prior==10){

            prior=1;}
        else {
            prior++;
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (this.getThreadGroup()!=null){
            this.setPriority(prior>this.getThreadGroup().getMaxPriority()?this.getThreadGroup().getMaxPriority():prior);
        } else
            this.setPriority(prior);

        if(prior==10){

            prior=1;}
        else {
            prior++;
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (this.getThreadGroup()!=null){
            this.setPriority(prior>this.getThreadGroup().getMaxPriority()?this.getThreadGroup().getMaxPriority():prior);
        } else
            this.setPriority(prior);

        if(prior==10){

            prior=1;}
        else {
            prior++;
        }
    }
}
/*Приоритеты в Threads
В отдельном файле создай класс MyThread унаследовавшись от Thread. MyThread должен:
1. Иметь возможность быть созданным используя любой конструктор супер-класса (Alt+Insert).
2. Приоритет у трэдов должен проставляться циклично от минимального значения до максимального значения.
3. если у трэда установлена трэд-группа(ThreadGroup), то приоритет трэда не может быть больше максимального приоритета его трэд-группы.


Требования:
1. Создай класс MyThread в отдельном файле. Унаследуй его от Thread.
2. В классе MyThread должны присутствовать конструкторы, аналогичные конструкторам супер-класса.
3. Приоритет у объектов MyThread должен проставляться циклично, от MIN_PRIORITY до MAX_PRIORITY.
4. Если у объекта MyThread установлена ThreadGroup, приоритет MyThread не должен быть выше максимального приоритета ThreadGroup.*/