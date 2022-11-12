package com.example.validatingforminput;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class StudentController implements WebMvcConfigurer {
    //TODO: Add spring annotations

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    public String showForm(Student student) {
        return "student";
    }

    public String checkStudentInfo(Student studentForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "student";
        }

        return "redirect:/results";
    }
}
