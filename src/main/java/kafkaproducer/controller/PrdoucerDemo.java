package kafkaproducer.controller;

import kafkaproducer.config.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrdoucerDemo {
    @Autowired
    KafkaTemplate<String, Book> kafkaTemplate;
    private static final String Topic="NewTopic";
    @PostMapping("/publish")
    public String publishMessage(@RequestBody Book book){
        kafkaTemplate.send(Topic,book);
        return "Published Successfully";
    }
}
