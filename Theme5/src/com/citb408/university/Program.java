package com.citb408.university;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private String name;
    private ProgramType programType;
    private List<Course> courseList;

    public Program(String name) {
        this.name = name;
        this.courseList = new ArrayList<>();
    }

    public Program(String name, ProgramType programType) {
        this.name = name;
        this.programType = programType;
        this.courseList = new ArrayList<>(); // program with empty list of courses
    }

    public Program(String name, ProgramType programType, List<Course> courseList) {
        this.name = name;
        this.programType = programType;
        this.courseList = courseList;
    }

    public String getName() {
        return name;
    }

    public ProgramType getProgramType() {
        return programType;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    //1. Метод за добавяне на курс
    public void addCourse(Course course) {
        if (!this.courseList.contains(course)) {
            this.courseList.add(course);
        }
    }

    //2. Метод за премахване на курс
    public void removeCourse(Course course) {
        this.courseList.remove(course);
    }

    //3. Метод за показване на курсовете в програмата
    public void printCourseList() {
        //foreach loop
        System.out.println("Course List of " + this.name);
        for (Course course : this.courseList) {
            System.out.println(course);
        }
    }

    //4. Метод за показване на задължителните или избираемите курсове, в зависимост от параметъра, който се предава на метода
    public void printCourseListByCourseType(CourseType courseType) {
        //foreach loop
        System.out.println("Course List of " + this.name + " by Course type");
        for (Course course : this.courseList) {
            if(course.getCourseType().equals(courseType)){
                System.out.println(course);
            }
        }
    }

    @Override
    public String toString() {
        return "Program{" +
                "name='" + name + '\'' +
                ", programType=" + programType +
              //  ", courseList=" + courseList +
                '}';
    }
}
