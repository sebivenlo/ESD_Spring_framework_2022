package com.example.dependency_injection.texteditor;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.ArrayList;


public class SpellChecker {
    //TODO 1: make this dependency injectable
    private ArrayList<String> words;

    public SpellChecker() throws IOException{
        words = new ArrayList<>();
        Resource resource = new ClassPathResource("spellcheck/words_alpha.txt");
        File file = resource.getFile();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        bufferedReader.lines().forEach(line -> words.add(line));
    }

    public boolean spellCheck(String word) {
        word = word.toLowerCase();
        return words.stream().anyMatch(word::equals);
    }
}
