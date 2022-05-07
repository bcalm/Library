package com.library.producer;

import com.library.schema.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class SpringAvroProducer {

    @Value("${avro.topic.name}")
    String topicName;

    @Autowired
    private KafkaTemplate<String, Book> kafkaTemplate;

    public void send(Book Book) {
        ListenableFuture<SendResult<String, Book>> future = kafkaTemplate.send(topicName, String.valueOf(Book.getId()), Book);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Book>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Message failed to produce");
            }

            @Override
            public void onSuccess(SendResult<String, Book> result) {
                System.out.println("Avro message successfully produced");
            }
        });

    }

}
