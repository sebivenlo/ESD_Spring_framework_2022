package com.example.template;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final int id = 1;
    private final int PCN = 202050;
    private static final String firstNameTemplate = "%s";
    private static final String lastNameTemplate = "%s";

    /**
     * Returns a student based on the parameters provided
     *
     * @param firstName The firstname of the student.
     * @param lastName The lastname of the student
     *
     * @return a new student object.
     */
    @GetMapping("/student")
    public Student createStudent(@RequestParam(defaultValue = "Marek") String firstName, @RequestParam(defaultValue = "Broz") String lastName) {
        return new Student(id, PCN, String.format(firstNameTemplate, firstName),String.format(lastNameTemplate, lastName));
    }
}
