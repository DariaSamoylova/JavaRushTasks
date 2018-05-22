package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
      //  LogParser logParser = new LogParser(Paths.get("c:/logs/"));
        //c:\Users\mr_ma\Documents\Даша\jv\JavaRushTasks\4.JavaCollections\src\com\javarush\task\task39\task3913\logs\
     //   LogParser logParser = new LogParser(Paths.get("c:/Users/mr_ma/Documents/Даша/jv/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3913/logs/"));
        LogParser logParser = new LogParser(Paths.get("c:/Users/mr_ma/Documents/Даша/jv/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3913/logs/"));
       // System.out.println(logParser.getNumberOfUniqueIPs(null, null));
     //   System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
      //   String ggg="wer ert";
       // System.out.println(ggg.indexOf('s'));
      //  System.out.println( ggg.substring(0, ggg.indexOf('y')-1));
      //  System.out.println(logParser.getDoneTaskUsers(null, null,15));
       // System.out.println( logParser.execute("get event for date = \"30.01.2014 12:56:22\""));
      //  System.out.println( logParser.execute("get ip for user = \"Vasya Pupkin\""));

String query="get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"";
        System.out.println( logParser.execute(query));
       // System.out.println(query.substring(query.indexOf("for")+4,query.indexOf("=")-1));
      //  System.out.println( query.substring(query.indexOf("=")+3,query.length()-1));
    }
}