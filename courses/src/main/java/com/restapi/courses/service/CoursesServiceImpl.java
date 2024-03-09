package com.restapi.courses.service;

import com.restapi.courses.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {

//    List<Courses> courses;
    @Autowired
    private CoursesDao coursesDao;

    public CoursesServiceImpl() {
//        courses = new ArrayList<>();
//        courses.add(new Courses(123L, "Course 1", "Courses-1 api using spring boot"));
//        courses.add(new Courses(456L, "Course 2", "Courses-2 api using spring boot"));
    }

    @Override
    public List<Courses> findAll() {
//        return courses;
        return coursesDao.findAll();
    }

    @Override
    public Courses findById(Long id) {
//        return courses.stream().filter(course -> course.getId().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException());
        return coursesDao.findById(id).orElseThrow(()-> new IllegalArgumentException());
    }

    @Override
    public Courses create(Courses course) {
//        courses.add(course);
        coursesDao.save(course);
        return course;
    }

    @Override
    public void update(Long id, Courses course) {
//        Courses existing = courses.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException());
//        int index = courses.indexOf(existing);
//        courses.set(index, course);
        coursesDao.save(course);
    }

    @Override
    public void delete(Long id) {
//        Courses existing = courses.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException());
//        int index = courses.indexOf(existing);
//        courses.remove(index);

        // courses.removeIf(course -> course.getId().equals(id));
        Courses entity = coursesDao.findById(id).orElseThrow(()-> new IllegalArgumentException());
        coursesDao.delete(entity);
    }

}
