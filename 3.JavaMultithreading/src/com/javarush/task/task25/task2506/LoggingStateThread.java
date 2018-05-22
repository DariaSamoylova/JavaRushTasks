package com.javarush.task.task25.task2506;

/**
 * Created by mr_ma on 02.11.2017.
 */
public class LoggingStateThread extends     Thread {

        Thread th;//=new Thread();
        LoggingStateThread(Thread t){
            this.th = t;
        }

  /*  @Override
        public void run(){
            State st=null;//th.getState() ;
           // System.out.println("st:"+th.getState());
            while( th.getState() != State.TERMINATED ) {
                if (st != th.getState()) {

                    st = th.getState();
                    System.out.println(st);
                }
            }
        }*/
  public void run() {
      Thread.State currentState = th.getState();
      System.out.println(currentState);
      while (!currentState.equals(State.TERMINATED)){
          Thread.State newState = th.getState();
          if (!currentState.equals(newState)){
              System.out.println(newState);
              currentState = newState;
          }
      }
  }

}
