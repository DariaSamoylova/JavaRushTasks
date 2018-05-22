package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.CashMachine.RESOURCE_PATH;

/**
 * Created by mr_ma on 02.04.2018.
 */
public class LoginCommand implements  Command {
    private ResourceBundle res =  ResourceBundle.getBundle( RESOURCE_PATH+"login_en");
    private ResourceBundle validCreditCards =  ResourceBundle.getBundle(RESOURCE_PATH+"verifiedCards");;
    final static String CARD = "123456789012";
    final static String PIN = "1234";

    @Override
    public void execute() throws InterruptOperationException {
     /*   ConsoleHelper.writeMessage(res.getString("before"));
            while(true) {
              //  ConsoleHelper.writeMessage("ЛОГИН: введи 2 числа - номер кредитной карты, состоящий из 12 цифр, и пин - состоящий из 4 цифр.");
                ConsoleHelper.writeMessage(res.getString("specify.data"));
                String cardNumber = ConsoleHelper.readString();
                if (cardNumber.equalsIgnoreCase("exit")) {
                    throw new InterruptOperationException();
                }
                String pinNumber = ConsoleHelper.readString();
                if (pinNumber.equalsIgnoreCase("exit")) {
                    throw new InterruptOperationException();
                }
                if (cardNumber==null||pinNumber==null)  {
                  //  ConsoleHelper.writeMessage("wrong data");
                    ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));

                    continue;
                }

                if (!validCreditCards.containsKey(cardNumber))  {
                   // ConsoleHelper.writeMessage("wrong data");
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
                    continue;
                }
                if (!validCreditCards.getString(cardNumber).equals(pinNumber)) {
                   // ConsoleHelper.writeMessage("wrong data");
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    continue;
                }
               // ConsoleHelper.writeMessage("верификация прошла успешно.");
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumber));
                break;

            }
*/

        ConsoleHelper.writeMessage(res.getString("before"));
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String s1 = ConsoleHelper.readString();
            String s2 = ConsoleHelper.readString();
            if (validCreditCards.containsKey(s1)) {
                if (validCreditCards.getString(s1).equals(s2))
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), s1));
                else {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), s1));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    continue;
                }
            } else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), s1));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }

            break;
        }

    }
}
/*3.1. В LoginCommand добавь поле private ResourceBundle validCreditCards.
При объявлении инициализируй это поле данными из файла verifiedCards.properties.
Почитай в инете, как это делается для ResourceBundle.
Важно: путь к ресурсу verifiedCards.properties строй динамически, для этого используй у класса CashMachine метод getPackage()
2. Замени хардкоженные данные кредитной карточки и пина на проверку наличия данных в ресурсе verifiedCards.properties.

private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".login_en");
Требования:
1. LoginCommand должен содержать приватное поле ResourceBundle validCreditCards.
2. Поле validCreditCards должно быть проинициализировано из файла verifiedCards.properties.
3. Используй проверку кредитной карточки и пина через verifiedCards.properties.*/