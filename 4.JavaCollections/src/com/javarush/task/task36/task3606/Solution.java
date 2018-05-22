package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/*
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
           Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");

        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));

    }
//   Solution solution = new Solution(  "c:\\Users\\mr_ma\\Documents\\Даша\\jv\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task36\\task3606\\data\\second");
    //  System.out.println(solution.getHiddenClassObjectByKey("test"));
    public void scanFileSystem() throws ClassNotFoundException {
        ArrayList<Class> classArrayList = new ArrayList<>();

        File file = new File(packageName);
        File[] files = file.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });

        ClassLoaderFromPath classLoader = new ClassLoaderFromPath();

        for (File f : files) {
            Class<?> clazz = classLoader.load(f.toPath());
            if (clazz != null)
                classArrayList.add(clazz);
        }

        for (Class f : classArrayList) {
            Constructor[] constructors = f.getDeclaredConstructors();
            boolean consOk = false;
            for (Constructor c : constructors) {
                if (c.getParameterCount() == 0)
                    consOk = true;
            }
            Class[] interfaces = f.getInterfaces();
            boolean interOk = false;
            for (Class intfs : interfaces) {
                if (intfs.getSimpleName().equals("HiddenClass"))
                    interOk = true;
            }

          //  if (consOk && interOk)
            if (consOk || interOk)
                hiddenClasses.add(f);
        }
    }
/*File file = new File("c:\\myclasses\\");
------
  File[] files = new File(packageName).listFiles();
        ClassLoaderFromPath classLoader = new ClassLoaderFromPath();

        for (File f : files) {
            Class<?> clazz = classLoader.load(f.toPath());
            if (clazz != null)
                hiddenClasses.add(clazz);
        }
        ----------------
try {
    // Convert File to a URL
    URL url = file.toURL();          // file:/c:/myclasses/
    URL[] urls = new URL[]{url};

    // Create a new class loader with the directory
    ClassLoader cl = new URLClassLoader(urls);

    // Load in the class; MyClass.class should be located in
    // the directory file:/c:/myclasses/com/mycompany
    Class cls = cl.loadClass("com.mycompany.MyClass");
} catch (MalformedURLException e) {
} catch (ClassNotFoundException e) {
}*/

     //   URL[] urls = new URL[files.length];





   /* public HiddenClass getHiddenClassObjectByKey(String key) {
        for(Class c:hiddenClasses){
            if (c.getSimpleName().toLowerCase().startsWith(key.toLowerCase())){
                try {
                    return (HiddenClass)c.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }*/

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class<?> clazz : hiddenClasses) {
            if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                try {
                    Constructor[] constructors = clazz.getDeclaredConstructors();
                    for (Constructor constructor : constructors) {
                        if (constructor.getParameterTypes().length == 0) {
                            constructor.setAccessible(true);
                            return (HiddenClass) constructor.newInstance(null);
                        }
                    }
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return null;
    }


    public static class ClassLoaderFromPath extends ClassLoader {
        public Class<?> load(Path path) {
            try {
             byte[] b = Files.readAllBytes(path);
                return defineClass(null, b, 0, b.length); //here main magic
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}

/*Осваиваем ClassLoader и Reflection
Аргументом для класса Solution является абсолютный путь к пакету.
Имя пакета может содержать File.separator.
В этом пакете кроме скомпилированных классов (.class) могут находиться и другие файлы (например: .java).
Известно, что каждый класс имеет конструктор без параметров и реализует интерфейс HiddenClass.
Считай все классы с файловой системы, создай фабрику - реализуй метод getHiddenClassObjectByKey.
Примечание: в пакете может быть только один класс, простое имя которого начинается с String key без учета регистра.


Требования:
1. Реализуй метод scanFileSystem, он должен добавлять в поле hiddenClasses найденные классы.
2. Реализуй метод getHiddenClassObjectByKey, он должен создавать объект класса согласно условию задачи.
3. Метод main не изменяй.
4. Метод getHiddenClassObjectByKey не должен кидать исключений.*/