package com.springrest.streamsschedule.controller;

import com.springrest.streamsschedule.model.LiveStream;
import com.springrest.streamsschedule.repository.LiveStreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

    @Autowired
    private final LiveStreamRepository repository;

    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }

    //GET http://localhost:8080/streams
    @GetMapping
    public List<LiveStream> findAll() {
        return repository.findAll();
    }

    //GET http://localhost:8080/streams/1234-1234-1234-1234
    @GetMapping("/{id}")
    public LiveStream findById(@PathVariable String id) {
        return  repository.findById(id);
    }

    //POST http://localhost:8080/streams
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LiveStream create(@RequestBody LiveStream stream) {
        return repository.create(stream);
    }

    //PUT http://localhost:8080/streams/1234-1234-1234-1234
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody LiveStream stream, @PathVariable String id) {
        repository.update(stream, id);
    }

    //DELETE http://localhost:8080/streams/1234-1234-1234-1234
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }
}
