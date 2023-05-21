/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cscb525;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Task 3 Week 2
 * @author Kostadinova
 */
public class Program {

    private String name;
    private Set<Course> hashSetOfCourses;
    private Set<Course> treeSetOfCourses;

    public Program() {
        this.name = "No name";
        this.hashSetOfCourses = new HashSet<>();
        this.treeSetOfCourses = new TreeSet<>();
    }

    public Program(String name) {
        this.name = name;
        this.hashSetOfCourses = new HashSet<>();
        this.treeSetOfCourses = new TreeSet<>();
    }

    public Program(String name, HashSet<Course> hashSetOfCourses, TreeSet<Course> treeSetOfCourses) {
        this.name = name;
        this.hashSetOfCourses = hashSetOfCourses;
        this.treeSetOfCourses = treeSetOfCourses;
    }

    public String getName() {
        return name;
    }

    public Set<Course> getHashSetOfCourses() {
        return hashSetOfCourses;
    }

    public Set<Course> getTreeSetOfCourses() {
        return treeSetOfCourses;
    }

    public void addCourseToHashSet(Course course) {

        hashSetOfCourses.add(course);
    }

    public void addCourseToTreeSet(Course course) {

        treeSetOfCourses.add(course);
    }

    public void displayCoursesInHashSet() {
        System.out.println("Courses in HashSet: ");
        for (Course course : hashSetOfCourses) {
            System.out.println(course);
        }
    }

    public void displayCoursesInTreeSet() {
        System.out.println("Courses in TreeSet: ");
        for (Course course : treeSetOfCourses) {
            System.out.println(course);
        }
    }

    @Override
    public String toString() {
        return "Program{" + "name=" + name + ", hashSetOfCourses=" + hashSetOfCourses + ", treeSetOfCourses=" + treeSetOfCourses + '}';
    }

}
