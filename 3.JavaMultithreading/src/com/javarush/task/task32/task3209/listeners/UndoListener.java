package com.javarush.task.task32.task3209.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 * Created by mr_ma on 15.05.2018.
 */
public class UndoListener implements UndoableEditListener {
    private UndoManager undoManager;

    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        undoManager.addEdit(e.getEdit());
    }


}
/*11.3.3. Метод undoableEditHappened(UndoableEditEvent e). Он должен из переданного события получать правку и добавлять ее в undoManager.
11.4. Добавь в представление поле UndoListener undoListener, проинициализируй его используя undoManager.
11.5. Добавь в представление методы:
11.5.1. void undo() - отменяет последнее действие. Реализуй его используя undoManager.
Метод не должен кидать исключений, логируй их.
11.5.2. void redo() - возвращает ранее отмененное действие. Реализуй его по аналогии с предыдущим пунктом.
11.5.3. Реализуй методы boolean canUndo() и boolean canRedo() используя undoManager.
11.5.4. Реализуй геттер для undoListener.
11.5.5. Добавь и реализуй метод void resetUndo(), который должен сбрасывать все правки в менеджере undoManager.*/