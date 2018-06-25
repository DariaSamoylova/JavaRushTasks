package com.javarush.task.task30.task3004;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by mr_ma on 21.06.2018.
 */
public class BinaryRepresentationTask  extends RecursiveTask<String> {
    private  int x;
    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        List<BinaryRepresentationTask> subTasks = new LinkedList<>();
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork(); // запустим асинхронно
            subTasks.add(task);
           // return binaryRepresentationMethod(b) + result;
        }
        for(BinaryRepresentationTask task : subTasks) {
            result = task.join()+result; // дождёмся выполнения задачи и прибавим результат
        }
        return result;
    }
}
/*2. Реализуй логику метода compute - число должно переводиться в двоичное представление.
3. Используй методы fork и join.
4. Пример функциональной реализации - метод binaryRepresentationMethod.
  int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            return binaryRepresentationMethod(b) + result;
        }
        return result;
------------
protected Long compute() {
        long sum = node.getValue();
        List<ValueSumCounter> subTasks = new LinkedList<>();

        for(Node child : node.getChildren()) {
            ValueSumCounter task = new ValueSumCounter(child);
            task.fork(); // запустим асинхронно
            subTasks.add(task);
        }

        for(ValueSumCounter task : subTasks) {
            sum += task.join(); // дождёмся выполнения задачи и прибавим результат
        }

        return sum;
    }*/