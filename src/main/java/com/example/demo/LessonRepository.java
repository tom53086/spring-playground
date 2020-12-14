package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
    Lesson findByTitle(String title);
    //List<Lesson> findByDateBetween(LocalDate date1, LocalDate date2);
}
