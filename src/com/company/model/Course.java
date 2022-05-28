package com.company.model;

import com.company.repository.CourseRepository;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Course {

    private int id;
    String title;
    String description;

    private static int lastId;
    public static DefaultTableModel model = new DefaultTableModel();


    public Course(String title, String description) {
        setProperties(++lastId, title, description);
        CourseRepository.addCourse(id, title, description);

    }

    public Course(int id, String title, String description){
        lastId = id;
        setProperties(id, title, description);
    }

    public void setProperties(int id, String title, String description){

        this.id = id;
        this.title = title;
        this.description = description;
        model.addRow(new Object[]{this.id, title, description});
    }


    public String getInfo() {
        return this.id + " " + this.title + "\n" + this.description;
    }


    public int getId() {
        return id;
    }

    public ArrayList<Student> getStudents() {
        return CourseEnrollment.getStudentsByCourse(this);
    }

    public String toString() {
        return this.id + " " + this.title;
    }
}

