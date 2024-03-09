package com.restapi.courses.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Courses {

    @Id
    private Long id;
    private String title;
    private String description;

    public Courses(){
        super();
    }
    public Courses(Long id, String title, String description) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
