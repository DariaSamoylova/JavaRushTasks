package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.CashMachine.RESOURCE_PATH;

/**
 * Created by mr_ma on 30.03.2018.
 */
  class InfoCommand  implements Command {
    private ResourceBundle res =  ResourceBundle.getBundle( RESOURCE_PATH+"info_en");
    @Override
    public void execute() {
      Locale.setDefault(Locale.ENGLISH);
     // String currCode = ConsoleHelper.askCurrencyCode();

      //CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currCode);
ConsoleHelper.writeMessage(res.getString("before"));
     // currencyManipulator.getTotalAmount();
      if (CurrencyManipulatorFactory.getAllCurrencyManipulators().isEmpty())
          ConsoleHelper.writeMessage(res.getString("no.money"));
      //  System.out.println("No money available.");
      for(CurrencyManipulator allManip:CurrencyManipulatorFactory.getAllCurrencyManipulators()){
       if (!allManip.hasMoney())
           ConsoleHelper.writeMessage(res.getString("no.money"));
        // System.out.println("No money available.");
       else
           ConsoleHelper.writeMessage(allManip.getCurrencyCode()+" - "+allManip.getTotalAmount());
      }

      /*2.2. В InfoCommand в цикле выведите [код валюты - общая сумма денег для выбранной валюты].*/
    }
}
