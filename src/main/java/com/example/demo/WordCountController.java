package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordCountController {

    private WordCounter wordCounter;

    public WordCountController(WordCounter wordCounter){
        this.wordCounter = wordCounter;
    }

    @PostMapping("/words/count")
    public String wordCounter(@RequestBody String input){
        return this.wordCounter.count(input).toString();
    }

}
