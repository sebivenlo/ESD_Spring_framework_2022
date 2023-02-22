package com.example.dependency_injection.texteditor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TextEditor {
    //TODO 2: add spell checker using Dependency Injection
    //TODO 3: utilise spell checker in checkUsingSpellchecker method
    //TODO Bonus: Check each word in the text and return a list of incorrectly spelled words

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
        boolean correctlySpelled = checkUsingSpellchecker(text);
        model.addAttribute("correct", correctlySpelled);
        return "texteditor";
    }




}
