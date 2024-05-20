package org.rahul.studentapp.service;

import org.rahul.studentapp.Model.Student;

import java.util.List;

public interface StudentService {


    List<Student> findAll();

    Student save(Student student);

    Student findById(int id);
}
