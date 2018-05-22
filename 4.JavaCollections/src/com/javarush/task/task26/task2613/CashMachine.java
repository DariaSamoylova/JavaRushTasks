package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by mr_ma on 29.03.2018.
 */
public class CashMachine {

    public static final String RESOURCE_PATH=   CashMachine.class.getPackage().getName() +  ".resources.";
    public  static void main(String args[]){
     try {
         CommandExecutor.execute(Operation.LOGIN);
         while(true){
             Operation operation =   ConsoleHelper.askOperation();

             CommandExecutor.execute(operation);
             if (operation==Operation.EXIT) break;
         }
     } catch (InterruptOperationException e ){
         ConsoleHelper.printExitMessage();
     }
    }

}
/*5. Пора уже увидеть приложение в действии.
В методе main захардкодь логику пункта 1.
Кстати, чтобы не было проблем с тестами на стороне сервера, добавь в метод main первой строчкой Locale.setDefault(Locale.ENGLISH);
Запускаем, дебажим, смотрим.

Выберем операцию, с которой мы сможем начать.
Подумаем. В банкомате еще денег нет, поэтому INFO и WITHDRAW протестить не получится.
Начнем с операции DEPOSIT - поместить деньги.
Считаем с консоли код валюты, потом считаем номинал и количество банкнот, а потом добавим их в манипулятор.
Операция LOGIN должна запускаться один раз, до выполнения всех операций.
Не забудь о InterruptOperationException, в любом месте пользователь может завершить работу с банкоматом. Поэтому добавь вызов операции внутрь блока try-catch.


а EUR 100 2 и USD 20 6

Требования:
1. Класс ConsoleHelper должен иметь статический метод String askCurrencyCode().
2. Класс ConsoleHelper должен иметь статический метод String[] getValidTwoDigits(String currencyCode).
3. Класс CurrencyManipulator должен иметь метод void addAmount(int denomination, int count).
4. Метод main класса CashMachine должен считывать с консоли код валюты, потом считывать номинал и количество банкнот, а потом добавлять их в манипулятор.*/