package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

//@Configuration
@Component
public class WordCounter {

    //@Bean
    public Map<String, Integer> count(String string){
        String[] split = string.split(" ");
        Map<String, Integer> result = new HashMap<>();
        for (String each : split){
            if(!result.containsKey(each)) result.put(each, 1);
            else{
                int count = result.get(each);
                result.put(each, count + 1);
            }
        }
        return result;
    }
}
