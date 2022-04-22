package com.citb408.university;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private final String facultyNumber;
    private boolean graduated;
    private List<Program> programs;
    private List<Course> courses;
    private List<Course> graduatedCourses;

    public Student(String name, String facultyNumber) {
        this.name = name;
        this.facultyNumber = facultyNumber;
        this.graduated = false;
        this.programs = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.graduatedCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public boolean isProgramTypeEnrolled(ProgramType programType) {
        for (Program program : this.programs) {
            if (program.getProgramType() == programType) {
                return true;
            }
        }
        return false;
    }

    //1. Метод за записване на студент в програма.
    public void addProgram(Program program) {
        if (!this.isProgramTypeEnrolled(program.getProgramType())) {
            this.programs.add(program);
        }
    }

    //3. Метод за „отписване“ от курс.
    public void removeProgram(Program program) {
        this.programs.remove(program);
    }

    //2. Метод за записване на студент в курс – необходимо е да се направи проверка за това, дали курсът,
    // който се предава като аргумент на метода се предлага от програмите, в които се записан студентът.
    public void addCourse(Course course) {
        boolean isCourseAdded = false;
        for (Program program : this.programs) {
            if (program.getCourseList().contains(course)) {
                this.courses.add(course);
                isCourseAdded = true;
                break;
            }
        }
        System.out.println("The course is added: " + isCourseAdded);
    }

    //4. Метод за „завършване“ на курс (добавяне на курс в списъка със завършените курсове)
    public boolean addCourseWithCredits(Course course) {
        if (this.courses.contains(course)) {
            this.graduatedCourses.add(course);
            return true;
        }
        return false;
    }
    public void removeCourse(Course course) {
        this.courses.remove(course);
    }

    //5. Метод, който връща броя на кредитите, които студентът е взел до момента
    public int numberOfCredits() {
        int sum = 0;
        for (Course course : this.graduatedCourses) {
            sum += course.getNumberOfCredits();
        }
        return sum;
    }

    //6. Метод, който връща колко кредита остават на студента, за да се дипломира
    // (всеки студент трябва да събере броя на кредитите в MAJOR програмата, за да се дипломира)
    public int numberOfCreditsToGet(){
        return ProgramType.MAJOR.getNumberOfCredits() - this.numberOfCredits();
    }

    //7. Метод, който променя състоянието на студента в дипломиран.
    public void graduateStudent() {
        if (numberOfCreditsToGet() == 0) {
            this.graduated = true;
        }
    }

    public void graduateCourse(Course course) {
        boolean isCourseGraduated = false;
        if (this.courses.contains(course)) {
            this.graduatedCourses.add(course);
            isCourseGraduated = true;
        }
        System.out.println("The course is graduated: " + isCourseGraduated);
    }

    public void removeGraduatedCourse(Course course) {
        this.graduatedCourses.remove(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", facultyNumber='" + facultyNumber + '\'' +
                ", graduated=" + graduated +
                ", programs=" + programs +
                ", courses=" + courses +
                ", graduatedCourses=" + graduatedCourses +
                '}';
    }
}
