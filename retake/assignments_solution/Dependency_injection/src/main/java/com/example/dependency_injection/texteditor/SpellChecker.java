package com.example.dependency_injection.texteditor;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("SpellChecker")
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
