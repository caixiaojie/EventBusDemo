package com.sky.sky.eventbusdemo.event;

import com.sky.sky.eventbusdemo.bean.Student;

import java.util.List;

/**
 * Created by BlueSky on 16/12/23.
 */

public class FronFragmentToFirst {

    Student student;

    List<Student> students;

    public FronFragmentToFirst() {
    }

    public FronFragmentToFirst(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
