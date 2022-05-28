package com.company.view.course;

import com.company.model.Course;

import javax.swing.*;

public class CourseListPanel extends JPanel {
    public CourseListPanel(){

        Course.model.setColumnIdentifiers(new String[]{"ID", "Title", "Description"});
        JTable table = new JTable();
        table.setModel(Course.model);
        add(new JScrollPane(table));
    }
}
