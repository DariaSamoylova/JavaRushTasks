package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students=new ArrayList();

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public int getAge() {
        return age;
    }

    private String name;
    private int age;

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {

        return students;
    }

    public University( String name,int age ){

    }



    public Student getStudentWithMaxAverageGrade() {
        double max=Double.MIN_VALUE;
        Student res=null;
        for(Student s:students){
            if (s.getAverageGrade()>max){
                max = s.getAverageGrade();
                res=s;
            }
        }
        return res;
    }

    public void expel(Student student) {
         students.remove(student);
    }
    public Student getStudentWithMinAverageGrade(){
        double min=Double.MAX_VALUE;
        Student res=null;
        for(Student s:students){
            if (s.getAverageGrade()<min){
                min = s.getAverageGrade();
                res=s;
            }
        }
        return res;
    }

    public  Student  getStudentWithAverageGrade(double k){
      //  List<Student> newStudents=new ArrayList();
        for(Student s:students){
            if (s.getAverageGrade()==k){
                //newStudents.add(s);
                return s;
            }
        }
        return null;
    }
}