package com.example.demo;

import org.junit.runner.Runner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository){
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all(){
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson){
        return this.repository.save(lesson);
    }

    @GetMapping("/{id}")
    public Optional<Lesson> read(@PathVariable long id){
        return this.repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.repository.deleteById(id);
    }

    @PatchMapping("/{id}")
    public Lesson patch(@PathVariable Long id, @RequestBody Lesson lessonDetails) {

        Optional<Lesson> lesson = this.repository.findById(id);
        if(lesson.isPresent()){
            Lesson newLesson = lesson.get();
            newLesson.setTitle(lessonDetails.getTitle());
            newLesson.setDeliveredOn(lessonDetails.getDeliveredOn());
            this.repository.save(newLesson);
        }
        return lesson.get();
    }

    @GetMapping("/find/{title}")
    public Lesson getTitle(@PathVariable String title){ return this.repository.findByTitle(title); }

//    @Query
//    @GetMapping("/between")
//    public List<Lesson> getDateBetween(@RequestParam String date1, @RequestParam String date2 ) {
//        LocalDate d1 = LocalDate.parse(date1);
//        LocalDate d2 = LocalDate.parse(date2);
//        return this.repository.findByDateBetween(d1, d2);
//    }
}
