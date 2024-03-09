package com.restapi.courses.service;

import com.restapi.courses.model.Courses;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CoursesService {

    public List<Courses> findAll();
    public Courses findById(Long id);
    public Courses create(Courses course);
    public void update(Long id, Courses course);
    public void delete(Long id);
}
