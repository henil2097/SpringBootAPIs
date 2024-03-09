package com.restapi.courses.service;

import com.restapi.courses.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesDao extends JpaRepository<Courses, Long> {
}
