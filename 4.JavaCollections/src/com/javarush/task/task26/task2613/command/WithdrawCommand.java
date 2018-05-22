package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

import static com.javarush.task.task26.task2613.CashMachine.RESOURCE_PATH;

/**
 * Created by mr_ma on 30.03.2018.
 */
  class WithdrawCommand implements Command {
    private ResourceBundle res =  ResourceBundle.getBundle(RESOURCE_PATH+"withdraw_en");
    @Override
    public void execute() throws InterruptOperationException {
    /*    ConsoleHelper.writeMessage(res.getString("before"));
      String code = ConsoleHelper.askCurrencyCode();
      CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);

    //  ConsoleHelper.writeMessage("vvedi summu");

        int sum=0;
        Map<Integer, Integer> denom = new HashMap<>();
        try {
        while(true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
              sum = Integer.parseInt(ConsoleHelper.readString());
              if (sum<=0)
              {
                  ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                  continue;
              }
            if (!currencyManipulator.isAmountAvailable(sum)) {
              //  ConsoleHelper.writeMessage("wrong data");
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
           break;

        }
         denom = currencyManipulator.withdrawAmount(sum);

ArrayList<Integer>  arrayList= new ArrayList<>(denom.keySet());
Collections.sort(arrayList);
for(int i=arrayList.size()-1;i>=0;i--){
  ConsoleHelper.writeMessage("\t"+arrayList.get(i)+" - "+denom.get(arrayList.get(i)));

}
         // ConsoleHelper.writeMessage("transaction success");
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), sum,code));
        } catch (NotEnoughMoneyException e) {
         //   ConsoleHelper.writeMessage("NotEnoughMoneyException");
            ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
        }  catch (Exception e) {
            ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
        }
*/


        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int sum;
        while(true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String s = ConsoleHelper.readString();
            try
            {
                sum = Integer.parseInt(s);
            } catch (NumberFormatException e)
            {
                continue;
            }
            if (sum <= 0)
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if (!currencyManipulator.isAmountAvailable(sum))
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
            try
            {
                currencyManipulator.withdrawAmount(sum);
            } catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), sum, currencyCode));
            break;
        }

    }
}

/*1
specify.amount=Please specify integer amount for withdrawing.
specify.not.empty.amount=Please specify valid positive integer amount for withdrawing.
not.enough.money=Not enough money on your account, please try again
exact.amount.not.available=Exact amount is not abvailable

. Реализуй следующий алгоритм для команды WithdrawCommand:
1.1. Считать код валюты (метод уже есть).
1.2. Получить манипулятор для этой валюты.
1.3. Пока пользователь не введет корректные данные выполнять:
1.3.1. Попросить ввести сумму.
1.3.2. Если введены некорректные данные, то сообщить об этом пользователю и вернуться к п. 1.3.
1.3.3. Проверить, достаточно ли средств на счету.
Для этого в манипуляторе создай метод boolean isAmountAvailable(int expectedAmount), который вернет true, если денег достаточно для выдачи.
Если недостаточно, то вернуться к п. 1.3.
1.3.4. Списать деньги со счета. Для этого в манируляторе создай метод
Map<Integer, Integer> withdrawAmount(int expectedAmount), который вернет карту Map<номинал, количество>.
Подробно логику этого метода смотри в п.2.
1.3.5. Вывести пользователю результат из п. 1.3.4. в следующем виде:
<табуляция>номинал - количество.
Сортировка - от большего номинала к меньшему.
Вывести сообщение об успешной транзакции.
1.3.6. Перехватить исключение NotEnoughMoneyException, уведомить юзера о нехватке банкнот и вернуться к п. 1.3.*/