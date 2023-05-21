/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cscb525;
import java.util.Comparator;
import java.util.Objects;

/**
 * Task 3 Week 2
 *
 * @author Kostadinova
 */
public class Course implements Comparable<Course> {

    private String name;
    private int numberOfCredits;

    public Course() {
    }

    public Course(String name, int numberOfCredits) {
        this.name = name;
        this.numberOfCredits = numberOfCredits;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    @Override
    public String toString() {
        return "Course{" + "name=" + name + ", numberOfCredits=" + numberOfCredits + '}';
    }

    @Override
    public int compareTo(Course course) {
        return this.name.compareTo(course.name);
    }

//    @Override
//    public int compareTo(Course course1) {
//        return Integer.compare(this.numberOfCredits, course1.numberOfCredits);
//    }

    public static Comparator<Course> ComparatorByCourseName = new Comparator<Course>() {
        @Override
        public int compare(Course course, Course course1) {
            return course.name.compareTo(course1.name);
        }
    };

    public static Comparator<Course> ComparatorByCourseNumberOfCredits = new Comparator<Course>() {
        @Override
        public int compare(Course course, Course course1) {
            return Integer.compare(course.numberOfCredits, course.numberOfCredits);
        }
    };
}
