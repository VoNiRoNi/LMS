package com.company.model;

import java.util.ArrayList;

public class CourseEnrollment {
    int id;
    Student student;
    Course course;

    static int lastID;
    static ArrayList<CourseEnrollment> allCE = new ArrayList<>();

    public CourseEnrollment(Student student, Course course) {
        this.id = ++lastID;
        this.student = student;
        this.course = course;
        allCE.add(this);
    }

    public static ArrayList<Student> getStudentsByCourse(Course course) {
        ArrayList<Student> res = new ArrayList<>();
        for (CourseEnrollment ce : allCE){
            if (course.getId() == ce.course.getId()){
                res.add(ce.student);
            }
        }
        return res;
    }

    public static ArrayList<Course> getCoursesByStudent(Student student) {
        ArrayList<Course> res = new ArrayList<>();
        for (CourseEnrollment ce : allCE){
            if (student.getID() == ce.student.getID()){
                res.add(ce.course);
            }
        }
        return  res;
    }

    public static CourseEnrollment getCourseEnrollment(Student st, Course c){
        for (CourseEnrollment ce : allCE){
            if (ce.student.getID() == st.getID() && ce.course.getId() == c.getId()){
                return ce;
            }
        }
        return new CourseEnrollment(st, c);
    }

    public int getId() {
        return id;
    }
}
