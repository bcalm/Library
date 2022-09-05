package com.library.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.library.domain.BookModel;
import com.library.producer.KafkaProducer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class LibraryService {

    private final KafkaProducer producer;

    public LibraryService(KafkaProducer producer) {
        this.producer = producer;
    }

    public void addBook(Object bookModel) throws JsonProcessingException {
        producer.send(bookModel);
    }

    public void updateStatus(ConsumerRecord<Object, Object> record) throws IOException {
        Gson g = new Gson();
        BookModel book = g.fromJson((String) record.value(), BookModel.class);
        String bookName = book.getName();
        System.out.println(bookName.toUpperCase());
    }
}