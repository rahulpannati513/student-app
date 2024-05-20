package org.rahul.studentapp.controller;

import org.antlr.v4.runtime.misc.LogManager;
import org.rahul.studentapp.Dao.StudentRepo;
import org.rahul.studentapp.Model.Student;
import org.rahul.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping("/getStudents")
    public List<Student> getStudents(){

       return service.findAll();

    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){

        return service.save(student);
    }

//    @GetMapping("/getStudent/{id}")
//    public Student getStudent(@PathVariable int id){
//
//        return service.findById(id);
//    }
    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> getStudent(@PathVariable int id){
        try {
            Student student = service.findById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
