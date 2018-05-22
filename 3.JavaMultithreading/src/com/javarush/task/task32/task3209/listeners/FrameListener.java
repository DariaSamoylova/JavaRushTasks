package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by mr_ma on 14.05.2018.
 */
public class FrameListener extends WindowAdapter {
   private View view;

    @Override
    public void windowClosing(WindowEvent e) {
        view.exit();
    }

    public FrameListener(View view) {
        this.view = view;
    }
}
/*3.2.2. Иметь поле View view.
3.2.3. В конструкторе принимать View и инициализировать внутреннее поле.
3.2.4. Иметь переопределенный метод windowClosing(WindowEvent windowEvent), который должен вызывать exit() у представления.

*/