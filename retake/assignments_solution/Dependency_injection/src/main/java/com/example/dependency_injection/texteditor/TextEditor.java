package com.example.dependency_injection.texteditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TextEditor {
    //TODO 2: add spell checker using Dependency Injection
    //TODO 3: utilise spell checker in checkUsingSpellchecker method
    //TODO Bonus: Check each word in the text and return a list of incorrectly spelled words

    @Autowired
    SpellChecker checker;
    public TextEditor() {
    }

    public boolean checkUsingSpellchecker(String text) {
        return checker.spellCheck(text);
    }

    @GetMapping("/")
    public String textEditor() {
        return "texteditor";
    }
    @PostMapping("/")
    public String spellCheck(@RequestParam String text, Model model) {
        boolean correctlySpelled = false;
        for(String word : text.split(" ")){
            correctlySpelled = checkUsingSpellchecker(word);
            if(!correctlySpelled){
                break;
            }
        }
        //boolean correctlySpelled = checkUsingSpellchecker(text);
        //Pass correctlySpelled to thymeleaf
        model.addAttribute("correct", correctlySpelled);
        return "texteditor";
    }




}
