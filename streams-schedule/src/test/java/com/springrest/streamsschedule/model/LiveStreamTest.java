package com.springrest.streamsschedule.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LiveStreamTest {

    @Test
    void create_new_mutable_live_stream() {
        MutableLiveStream stream = new MutableLiveStream();
        stream.setId(UUID.randomUUID().toString());
        stream.setTitle("Build Live Stream REST APIs using Spring Boot");
        stream.setDescription("Making an API for live stream using Spring Boot which is very easy to learn and useful for microservices architecture");
        stream.setUrl("https://www.google.com");
        stream.setStartDate(LocalDateTime.of(2022, 8, 21, 10, 0));
        stream.setEndDate(LocalDateTime.of(2022, 8, 21, 11, 0));

        stream.setTitle("Mutated Live Stream API");
        assertNotNull(stream);
        assertEquals("Build Live Stream REST APIs using Spring Boot", stream.getTitle());
    }

    @Test
    void create_new_immutable_live_stream() {
        ImmutableLiveStream stream = new ImmutableLiveStream(UUID.randomUUID().toString(),
                "Build Live Stream REST APIs using Spring Boot",
                "Making an API for live stream using Spring Boot which is very easy to learn and useful for microservices architecture",
                "https://www.google.com",
                LocalDateTime.of(2022, 8, 21, 10, 0),
                LocalDateTime.of(2022, 8, 21, 11, 0)
                );

        assertNotNull(stream);
        assertEquals("Build Live Stream REST APIs using Spring Boot", stream.getTitle());
    }

    @Test
    void create_new_live_stream_record() {
        LiveStream stream = new LiveStream(UUID.randomUUID().toString(),
                "Build Live Stream REST APIs using Spring Boot",
                "Making an API for live stream using Spring Boot which is very easy to learn and useful for microservices architecture",
                "https://www.google.com",
                LocalDateTime.of(2022, 8, 21, 10, 0),
                LocalDateTime.of(2022, 8, 21, 11, 0)
        );

        assertNotNull(stream);
        assertEquals("Build Live Stream REST APIs using Spring Boot", stream.title());
        assertTrue(stream.getClass().isRecord());
        assertEquals(6,stream.getClass().getRecordComponents().length);
    }
}