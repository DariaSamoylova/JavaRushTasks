package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.CashMachine.RESOURCE_PATH;

/**
 * Created by mr_ma on 30.03.2018.
 */
  class DepositCommand implements Command {
  private ResourceBundle res =  ResourceBundle.getBundle( RESOURCE_PATH+"deposit_en");
    @Override
    public void execute() throws InterruptOperationException {
      Locale.setDefault(Locale.ENGLISH);
      ConsoleHelper.writeMessage(res.getString("before"));
      String currCode = null;

      try {
        currCode = ConsoleHelper.askCurrencyCode().toUpperCase();


        String[] nom_bank = ConsoleHelper.getValidTwoDigits(currCode);
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currCode);
        currencyManipulator.addAmount(Integer.parseInt(nom_bank[0]), Integer.parseInt(nom_bank[1]));
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), Integer.parseInt(nom_bank[0]) * Integer.parseInt(nom_bank[1]), currCode));
      } catch (Exception e){
        ConsoleHelper.writeMessage(res.getString("invalid.data"));
      }
    }
}
