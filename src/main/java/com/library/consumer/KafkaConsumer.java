package com.library.consumer;

import com.library.schema.Book;
import com.library.service.LibraryService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private final LibraryService libraryService;

    public KafkaConsumer(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @KafkaListener(topics = "${avro.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void read(ConsumerRecord<Integer, Book> record) {
        libraryService.updateStatus(record);
    }

}
