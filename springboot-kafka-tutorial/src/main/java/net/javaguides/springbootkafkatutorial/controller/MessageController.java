package net.javaguides.springbootkafkatutorial.controller;


import net.javaguides.springbootkafkatutorial.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    //Inject KafkaProducer
    private KafkaProducer kafkaProducer;


    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;

    }


    //Create a method to send message to Kafka topic
//http://localhost:8080/api/v1/publish?message=hello
 //   @GetMapping("/publish") //This annotation maps HTTP GET requests onto specific handler methods.

    @RequestMapping("/publish") //This annotation maps HTTP requests to handler methods of MVC and REST controllers.
    public String sendMessage(String message){
        kafkaProducer.sendMessage(message);
        return "Message sent to Kafka Topic Successfully";
    }
}
