package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//import static com.javarush.task.task16.task1624.Solution.t;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String f;
        ReadThread nit;
        while (true) {
            f = r.readLine();
            if (f.equals("exit")) break;
          nit=  new ReadThread(f);
          nit.start();

        }
        r.close();


      //  for (Map.Entry<String,Integer> s:resultMap.entrySet()) {
     //         System.out.println(s.getKey()+"--"+s.getValue());
      //  }
    }
//c:\Users\mr_ma\Documents\Даша\java\1.txt
    public static class ReadThread extends Thread {
        FileInputStream str;
        String fileName;

        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fileName = fileName;
            str = new FileInputStream(fileName);
        }

        public void run(){
            HashMap<Integer,Integer> h = new HashMap<>();
            int t,count=0,max=0;
            try {
                while (str.available()>0){
                t= str.read();
                //  System.out.println(t);
                if (h.containsKey(t)){
                    // System.out.println(t+"..."+h.get(t));
                    count=h.get(t);
                    h.put( t,++count);
                } else
                    h.put( t,1);

                if (max<count) max=count;
            }
                for (Map.Entry<Integer,Integer> s:h.entrySet()){
                    // System.out.println(s.getKey()+"--"+s.getValue());
                    if ((int)s.getValue()==max){
                     //   System.out.print(s.getKey()+" ");
                        resultMap.put(fileName,s.getKey());
                    }
                }
                // System.out.println(max);

                str.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}

/*

        for (Map.Entry s:h.entrySet()){
           // System.out.println(s.getKey()+"--"+s.getValue());
            if ((int)s.getValue()==max){
                System.out.print(s.getKey()+" ");
            }
        }
       // System.out.println(max);
        str.close();*/
/*Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово «exit«.
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String — это имя файла, параметр Integer — это искомый байт.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем, нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.*/