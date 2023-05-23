package com.example.dao.controller;

import java.util.ArrayList;

import com.example.dao.Model.student.Student;
import com.example.dao.repository.DataAccessRepository;
import com.example.dao.repository.StudentDataAccessRepository;

public class StudentController {
    private DataAccessRepository<Student> dao;

    public StudentController() {
        dao = new StudentDataAccessRepository();
    }

    public void setStudent(Student student) {
        int i = dao.save(student);
        if (i == 0)
            System.err.println("Log: Insertion failed");
        else
            System.out.println("Log: Student Added Successfully.");
    }

    public Student getStudent(int id) {
        Student st = dao.getOne(id);
        if (st == null)
            System.err.println("Log: No student with id: " + id);
        else
            System.out.println("Log: Student with id: " + id + " retrieved successfully.");
        return st;
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> sts = dao.getAll();
        if (sts == null)
            System.err.println("Log: Empty Database");
        else
            System.out.println("Log: Students retrieved successfully from database");
        return sts;
    }

    public void updateStudent(Student st) {
        int i = dao.update(st);
        if (i == 0)
            System.err.println("Log: Student: " + st + " update failed.");
        else
            System.out.println("Log: Student info updated successfully to " + dao.getOne(st.getId()));
    }

    public void removeStudent(int id) {
        int i = dao.delete(id);
        if (i == 0)
            System.err.println("Log: Student with id: " + id + " failed to delete");
        else
            System.out.println("Log: Student with id: " + id + " deleted successfully.");
    }
}
