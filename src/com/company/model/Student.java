package com.company.model;

import com.company.repository.StudentRepository;
import com.company.view.student.StudentListPanel;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Student {
    private int id;
    String name;
    String surname;

    private static int lastId;
    public static DefaultTableModel model = new DefaultTableModel();

    public Student(String name, String surname) {
        setProperties(++lastId, name, surname);
        StudentRepository.add(id, name, surname);

    }

    public Student(int id, String name, String surname) {
        lastId = id;
        setProperties(id, name, surname);
    }

    public static void update(int id, String name, String surname) {
        StudentRepository.update(id, name, surname);
    }

    public static void delete(int id, int rowIndex) {
        StudentRepository.delete(id);
        model.removeRow(rowIndex);
    }

    public void setProperties(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        model.addRow(new Object[]{id, name, surname});
    }

    public int getID() {
        return this.id;
    }

    public String getInfo() {
        return this.id + " " + this.name + " " + this.surname;
    }

    public ArrayList<Course> getCourses() {
        return CourseEnrollment.getCoursesByStudent(this);
    }

    public ArrayList<Integer> getMarks() {
        ArrayList<Integer> marks = new ArrayList<>();
        for (Course course : this.getCourses()) {
            marks.add(AcademicPerformance.getMarkByStudentAndCourse(this, course));
        }
        return marks;
    }

    public String toString() {
        return this.id + " " + this.name;
    }
}

