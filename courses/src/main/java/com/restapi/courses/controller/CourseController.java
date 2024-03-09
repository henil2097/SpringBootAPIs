package com.restapi.courses.controller;

import com.restapi.courses.model.Courses;
import com.restapi.courses.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CoursesService coursesService;

    // Get http://localhost:8080/courses
    @GetMapping
    public List<Courses> findAll() {
        return this.coursesService.findAll();
    }

    @GetMapping("/{id}")
    public Courses findById(@PathVariable String id) {
        return this.coursesService.findById(Long.parseLong(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Courses create(@RequestBody Courses course) {
        return this.coursesService.create(course);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Courses course) {
        this.coursesService.update(Long.parseLong(id), course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id) {
        try {
            this.coursesService.delete(Long.parseLong(id));
            return  new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
