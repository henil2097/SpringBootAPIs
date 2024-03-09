package com.springrest.streamsschedule.repository;

import com.springrest.streamsschedule.model.LiveStream;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LiveStreamRepository {

    List<LiveStream> streams = new ArrayList<>();

    public LiveStreamRepository() {
        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "Build Live Stream REST APIs using Spring Boot",
                "Making an API for live stream using Spring Boot which is very easy to learn and useful for microservices architecture",
                "https://www.google.com",
                LocalDateTime.of(2022, 8, 21, 10, 0),
                LocalDateTime.of(2022, 8, 21, 11, 0)
            )
        );
    }

    public List<LiveStream> findAll() {
        return streams;
    }

    public LiveStream findById(String id) {
        return streams.stream().filter(stream -> stream.id().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException("Stream not found"));
    }

    public LiveStream create(LiveStream stream) {
        streams.add(stream);
        return stream;
    }

    public void update(LiveStream stream, String id) {
        LiveStream existing = streams.stream().filter(s -> s.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Stream not found"));
        int i = streams.indexOf(existing);
        streams.set(i, stream);
    }

    public void delete(String id) {
        streams.removeIf(stream -> stream.id().equals(id));
    }
}
