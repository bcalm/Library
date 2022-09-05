package com.library.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducer {

    @Value("${avro.topic.name}")
    String topicName;

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public void send(Object book) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ListenableFuture<SendResult<Object, Object>> future = kafkaTemplate.send(topicName,
            mapper.writeValueAsString(book));
        future.addCallback(new ListenableFutureCallback<SendResult<Object, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Message failed to produce");
            }

            @Override
            public void onSuccess(SendResult<Object, Object> result) {
                System.out.println("Avro message successfully produced");
            }
        });

    }

}
