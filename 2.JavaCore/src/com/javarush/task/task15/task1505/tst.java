package com.javarush.task.task15.task1505;

/**
 * Created by mr_ma on 28.09.2017.
 */
public class tst {


        public static void print(int n)
        {
            System.out.println(n);
        }
        public static void print(short n)
        {
            System.out.println(n);
        }
         public static void print(Integer n)
        {
            System.out.println(n);
        }
       /* public static void print(String s)
        {
            System.out.println(s);
        }*/
        public static void main(String[] args)
        {
            tst.print(1);
            tst.print((byte)1);
        //    tst.print("1");
            tst.print(null);
        }

}
