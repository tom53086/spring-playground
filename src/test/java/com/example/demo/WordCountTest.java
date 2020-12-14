package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class WordCountTest {

    @Autowired
    private WordCounter wordCounter;

    @Autowired
    private MockMvc Mvc;

    @Test
    public void testWordCounter(){

    }

}
