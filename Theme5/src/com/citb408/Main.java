package com.citb408;

import com.citb408.university.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Course course1 = new Course("CITB408", 6, CourseType.REQUIRED);
        Course course2 = new Course("CSCB525", 3, CourseType.ELECTIVE);
        Course course3 = new Course("CSCB869");
        Course course4 = new Course("CSCB035");

        System.out.println(course1);
        System.out.println(course2);
        System.out.println(course3);

        Program program = new Program("Informatics", ProgramType.MAJOR);
        program.addCourse(course1);
        program.addCourse(course2);
        program.addCourse(course3);

        System.out.println(program);
        program.printCourseList();

        program.removeCourse(course3);
        program.printCourseList();

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course4);

        Program program2 = new Program("IT",ProgramType.MAJOR,courses);
        program2.printCourseList();

        program.printCourseListByCourseType(CourseType.REQUIRED);
        program.printCourseListByCourseType(CourseType.ELECTIVE);

        ProgramType.MAJOR.setNumberOfCredits(6);

        Student student = new Student("Ivan","F12345");
        student.addProgram(program);
        student.addCourse(course1);
        student.addCourse(course2);
        student.addCourse(course3);

        student.addCourseWithCredits(course1);
        student.addCourseWithCredits(course2);

        student.graduateStudent();

        System.out.println(student);

    }
}
