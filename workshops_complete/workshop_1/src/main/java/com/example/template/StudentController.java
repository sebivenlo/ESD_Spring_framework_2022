package com.example.template;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {


    /**
     * Returns a student based on the parameters provided
     *
     * @param firstName The firstname of the student.
     * @param lastName The lastname of the student
     *
     * @return a new student object.
     */
    @GetMapping("/student")
    public Student createStudent(@RequestParam(defaultValue = "0") int id, @RequestParam(defaultValue = "0") int PCN, @RequestParam(defaultValue = "Marek") String firstName, @RequestParam(defaultValue = "Broz") String lastName) {
        return new Student(id, PCN, String.format(firstNameTemplate, firstName),String.format(lastNameTemplate, lastName));
    }
}
