package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends    UniversityPerson {
 //   private List<Human> children = new ArrayList<>();
    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
       super(name,age);
      //   this.name = name;
      //  this.age = age;
        this.averageGrade = averageGrade;
    }
    public int getCourse() {
        return course;
    }
  //  public List<Human> getChildren() {
   //     return children;
  //  }

 //   public void setChildren(List<Human> children) {
  //      this.children = children;
  //  }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public String getPosition(){
        return "Студент";
    }





    public void  incAverageGrade(double delta){
        double d =   getAverageGrade();
        setAverageGrade(d +=delta);
        }

    public void setCourse(  int value) {
        this.course = value;
    }
    public void setAverageGrade(  double value) {
        this.averageGrade = value;
    }
   /* public void setValue(String name, double value) {
        if (name.equals("averageGrade")) {
            averageGrade = value;
            return;
        }
        if (name.equals("course")) {
            course = (int) value;
            return;
        }
    }*/

    public void setBeginningOfSession(Date d) {
        beginningOfSession = d;
    }

    public void setEndOfSession(Date d) {
        endOfSession = d;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}