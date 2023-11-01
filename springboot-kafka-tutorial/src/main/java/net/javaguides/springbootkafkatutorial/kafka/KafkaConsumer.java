package net.javaguides.springbootkafkatutorial.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service // This annotation indicates that an annotated class is a "Service" spring bean.
public class KafkaConsumer {

    //inject the kafka Logger
    private static final Logger LOGGER =  LoggerFactory.getLogger(KafkaConsumer.class); // This is the logger for this class.



    //set the listener to listen to the topic
     @KafkaListener(topics = "library-events" , groupId = "myGroup")
        public void onMessage(String message){
            System.out.println("Consumed message: " + message);
        }

        //it can be any number of listener.



}
