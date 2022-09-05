package com.library.consumer;

import com.library.service.LibraryService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumer {

    private final LibraryService libraryService;

    public KafkaConsumer(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @KafkaListener(topics = "${avro.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void read(ConsumerRecord<Object, Object> record) throws IOException {
        libraryService.updateStatus(record);
    }

}
