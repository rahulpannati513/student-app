package org.rahul.studentapp.service;


import org.rahul.studentapp.Dao.StudentRepo;
import org.rahul.studentapp.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImplementation  implements StudentService{

    @Autowired
    private StudentRepo repo;


    @Override
    public List<Student> findAll() {

        return repo.findAll();

    }

    @Override
    public Student save(Student student) {

        return repo.save(student);

    }
    @Override
    public Student findById(int id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }
}
