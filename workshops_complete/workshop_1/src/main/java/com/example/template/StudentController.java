package com.example.template;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class StudentController {
    //TODO: Add the spring annotations


    /**
     * Returns a student based on the parameters provided
     *
     * @param id the ID of the student, also known as the student number
     * @param PCN The PCN of the student.
     * @param firstName The firstname of the student.
     * @param lastName The lastname of the student
     *
     * @return a new student object.
     */
    public Student createStudent(int id, int PCN, String firstName, String lastName){
        return new Student(id, PCN, firstName, lastName);
    }
}
