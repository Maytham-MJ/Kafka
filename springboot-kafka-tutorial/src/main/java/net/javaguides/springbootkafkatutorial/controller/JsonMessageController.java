package net.javaguides.springbootkafkatutorial.controller;


import net.javaguides.springbootkafkatutorial.kafka.JsonKafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/v1/kafka")
public class JsonMessageController {

        //Inject JsonKafkaProducer
        private JsonKafkaProducer kafkaProducer;


        public JsonMessageController(JsonKafkaProducer kafkaProducer) {
            this.kafkaProducer = kafkaProducer;

        }

        //Creating Post
        //http://localhost:8080/api/v1/kafka/publish?message=HelloWorld
        @RequestMapping("/publish") //This annotation maps HTTP requests to handler methods of MVC and REST controllers.
        public ResponseEntity<String> publish(String message){
            kafkaProducer.sendMessage(message);
            return ResponseEntity.ok("Message sent to Kafka Topic Successfully");
        }


}
