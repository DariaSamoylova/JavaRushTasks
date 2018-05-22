package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.CashMachine.RESOURCE_PATH;

/**
 * Created by mr_ma on 29.03.2018.
 */
public class ConsoleHelper {
    private static ResourceBundle res =  ResourceBundle.getBundle( RESOURCE_PATH+"common_en");
   private static  BufferedReader bis  = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static    String readString() throws InterruptOperationException {
     //   bis   = new BufferedReader(new InputStreamReader(System.in));
        String g = null;
        try {
            g = bis.readLine();
           //  bis.close();
            if (g.equalsIgnoreCase("exit")) {
                writeMessage(res.getString("the.end"));
                throw new InterruptOperationException();
            }

        } catch (IOException e) {
          //  e.printStackTrace();
        }

        return  g;
    }

    public  static  String askCurrencyCode() throws InterruptOperationException {
        String code;
        while(true){
          //  writeMessage("ввести код валюты");
            writeMessage(res.getString("choose.currency.code"));
              code = readString();
            if (code!=null&&code.length()==3)
                break;
            else {
                writeMessage("код содержит не 3 символа");
                writeMessage(res.getString("invalid.data"));
            }
        }

            return code.toUpperCase();
    }

    public  static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String a  ;
        String[] ress;
        while(true){
           // writeMessage("ввести два целых положительных числа. Первое число - номинал, второе - количество банкнот");
          writeMessage(String.format(res.getString("choose.denomination.and.count.format"),currencyCode));
            a = readString();

              ress = a.split(" ");
          try {
              int aa=  Integer.parseInt(ress[0]);
              int bb=Integer.parseInt(ress[1]);
              if (aa == 0 || bb == 0)
                 // writeMessage(" данные некорректны");
                  writeMessage(res.getString("invalid.data"));
              else
                  break;
          } catch (Exception e){
             // writeMessage(" данные некорректны");
              writeMessage(res.getString("invalid.data"));
          }
        }
        return ress;
    }


    public  static Operation askOperation() throws InterruptOperationException {
        Integer a;

        while (true) {
           // writeMessage("Спросить у пользователя операцию. вводит 1 -INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;");
            writeMessage(res.getString("choose.operation")+", 1 - "+res.getString("operation.INFO")
                    +", 2 - "+res.getString("operation.DEPOSIT")
                    +", 3 - "+res.getString("operation.WITHDRAW")
                    +", 4 - "+res.getString("operation.EXIT"));
            try {
                a = Integer.parseInt(readString());
                if (a == 1 || a == 2 || a == 3 || a == 4)
                    break;
                else
                    //writeMessage(" данные некорректны");
                    writeMessage(res.getString("invalid.data"));
            } catch (Exception e) {
                writeMessage(res.getString("invalid.data"));
            }
        }

        return Operation.getAllowableOperationByOrdinal(a);
    }

    public  static  void printExitMessage(){
        writeMessage("bye");
    }
}
/*2.2. В классе ConsoleHelper реализуй логику статического метода Operation askOperation().
Спросить у пользователя операцию.
Если пользователь вводит 1, то выбирается команда INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
Используйте метод, описанный в п.1.
Обработай исключение - запроси данные об операции повторно.*/