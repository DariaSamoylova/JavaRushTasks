package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by mr_ma on 17.05.2018.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()||f.getName().toLowerCase().endsWith(".html")||f.getName().toLowerCase().endsWith(".htm"))
            return true;
        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
/*21.2. Мы хотим, чтобы окно выбора файла отображало только html/htm файлы или папки.
Переопредели метод accept(File file), чтобы он возвращал true, если переданный файл директория или содержит в конце имени ".html" или ".htm" без учета регистра.
21.3. Чтобы в окне выбора файла в описании доступных типов файлов отображался текст "HTML и HTM файлы" переопредели соответствующим образом метод getDescription().


Требования:
1. Класс HTMLFileFilter должен быть создан в отдельном файле.
2. Класс HTMLFileFilter должен наследоваться от FileFilter.
3. Метод accept(File file) класса HTMLFileFilter должен возвращать true, если переданный файл - директория или содержит в конце имени ".html" или ".htm" без учета регистра.
4. Метод accept(File file) класса HTMLFileFilter должен возвращать false, если переданный файл - НЕ директория или НЕ содержит в конце имени ".html" или ".htm" без учета регистра.
5. Метод getDescription() класса HTMLFileFilter должен возвращать строку "HTML и HTM файлы".
*/