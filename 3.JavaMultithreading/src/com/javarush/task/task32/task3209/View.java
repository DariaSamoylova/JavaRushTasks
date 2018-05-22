package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mr_ma on 14.05.2018.
 */
public class View extends JFrame implements ActionListener {
    private Controller controller;
private   JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

public  View(){
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException e) {
        ExceptionHandler.log(e);
    } catch (InstantiationException e) {
        ExceptionHandler.log(e);
    } catch (IllegalAccessException e) {
        ExceptionHandler.log(e);
    } catch (UnsupportedLookAndFeelException e) {
        ExceptionHandler.log(e);
    }
}
    public void initMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this,jMenuBar);
        MenuHelper.initEditMenu(this,jMenuBar);
        MenuHelper.initStyleMenu(this,jMenuBar);
        MenuHelper.initAlignMenu(this,jMenuBar);
        MenuHelper.initColorMenu(this,jMenuBar);
        MenuHelper.initFontMenu(this,jMenuBar);
        MenuHelper.initHelpMenu(this,jMenuBar);
        getContentPane().add(jMenuBar,BorderLayout.NORTH);
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public  boolean canUndo(){
        return  undoManager.canUndo();
    }

    public  boolean canRedo(){
        return  undoManager.canRedo();
    }

    public void undo() {
       try{
           undoManager.undo();
       } catch ( Exception e) {
           ExceptionHandler.log(e);
       }
    }

    public void redo() {
        try{
            undoManager.redo();
        } catch ( Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public  void resetUndo(){
        undoManager.discardAllEdits();
    }
    /*911.5. Добавь в представление методы:
11.5.1. void undo() - отменяет последнее действие. Реализуй его используя undoManager.
Метод не должен кидать исключений, логируй их.
11.5.2. void redo() - возвращает ранее отмененное действие. Реализуй его по аналогии с предыдущим пунктом.
11.5.3. Реализуй методы boolean canUndo() и boolean canRedo() используя undoManager.
11.5.4. Реализуй геттер для undoListener.
11.5.5. Добавь и реализуй метод void resetUndo(), который должен сбрасывать все правки в менеджере undoManager.*/

    public  void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane scrollHtmlTxtComponent = new JScrollPane(htmlTextPane);
        //Component scrollHtmlTxtComponent =     htmlTextPane.add(new JScrollPane());
        tabbedPane.addTab("HTML",scrollHtmlTxtComponent);
       // Component scrollPlainTxtComponent =     plainTextPane.add(new JScrollPane());
        JScrollPane scrollPlainTxtComponent = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст",scrollPlainTxtComponent);
        tabbedPane.setPreferredSize(new Dimension(200,200));
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
    }

    public  void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {

        return controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comm=e.getActionCommand();
        if (comm.equals("Новый")){
            controller.createNewDocument();
        } else  if (comm.equals("Открыть")){
            controller.openDocument();
        } else  if (comm.equals("Сохранить")){
            controller.saveDocument();
        } else  if (comm.equals("Сохранить как...")){
            controller.saveDocumentAs();
        } else  if (comm.equals("Выход")){
            controller.exit();
        }    else  if (comm.equals("О программе")){
            showAbout();
        }
    }

    public void init(){
        initGui();
        FrameListener frameListener = new FrameListener(this);
        super.addWindowListener(frameListener);
        setVisible(true);
        super.setResizable(true);

    }


    public  void exit(){
        controller.exit();
    }

    public void selectedTabChanged() {
        int tab=tabbedPane.getSelectedIndex();
        if (tab==0){
          controller.setPlainText(  plainTextPane.getText());
            resetUndo();
        }
       else if (tab==1){
            plainTextPane.setText( controller.getPlainText());
            resetUndo();
        }


    }

    public  boolean isHtmlTabSelected(){
        return  (tabbedPane.getSelectedIndex()==0);
    }

    public  void  selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public  void update(){
        htmlTextPane.setDocument(    controller.getDocument());
    }

    public  void showAbout(){
        JOptionPane.showMessageDialog(getContentPane(),new String("msg"),"info about prog", JOptionPane.INFORMATION_MESSAGE);
    }
}
/*.Реализуем метод actionPerformed(ActionEvent actionEvent) у представления, этот метод наследуется от интерфейса ActionListener и будет вызваться при выборе пунктов меню,
 у которых наше представление указано в виде слушателя событий.
19.1. Получи из события команду с помощью метода getActionCommand(). Это будет обычная строка. По этой строке ты можешь понять какой пункт меню создал данное событие.
19.2. Если это команда "Новый", вызови у контроллера метод createNewDocument(). В этом пункте и далее, если необходимого метода в контроллере еще нет - создай заглушки.
19.3. Если это команда "Открыть", вызови метод openDocument().
19.4. Если "Сохранить", то вызови saveDocument().
19.5. Если "Сохранить как..." - saveDocumentAs().
19.6. Если "Выход" - exit().
19.7. Если "О программе", то вызови метод showAbout() у представления.
Проверь, что заработали пункты меню Выход и О программе.


Требования:
1. Метод actionPerformed(ActionEvent actionEvent) должен получать из события команду с помощью метода getActionCommand().
2. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Новый", метод должен вызывать у контроллера createNewDocument().
3. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Открыть", метод должен вызывать у контроллера openDocument().
4. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Сохранить", метод должен вызывать у контроллера saveDocument().
5. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Сохранить как...", метод должен вызывать у контроллера saveDocumentAs().
6. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Выход", метод должен вызывать у контроллера exit().
7. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "О программе", метод должен вызывать у представления showAbout().

*/