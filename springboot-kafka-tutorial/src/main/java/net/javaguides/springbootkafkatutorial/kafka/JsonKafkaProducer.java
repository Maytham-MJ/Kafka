package net.javaguides.springbootkafkatutorial.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.webservices.client.HttpWebServiceMessageSenderBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service // This annotation indicates that an annotated class is a "Service" spring bean.

public class JsonKafkaProducer {

    //Insert the kafka logger
    private static final Logger LOGGER =  LoggerFactory.getLogger(JsonKafkaProducer.class); // This is the logger for this class.

    //Insert the kafka template
    private KafkaTemplate<String, String> kafkaTemplate;

    //Generate constructor for kafka template
    public JsonKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    //Generate method to send message and object

 public void sendMessage(String message) {


     LOGGER.info(String.format("Message Sent -> Producing message --> %s", message));

     Message<String> message1 = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, "library-events")
                .build();
        kafkaTemplate.send(message1);

     }


}


//Here we have created producer to send JSON message to Kafka topic.

//Create JsonKafkaProducer.java class inside the kafka package and add the following code:

//1. Insert @Service annotation to make it as spring bean
//2. Insert the kafka logger
//3. Insert the kafka template
//4. Generate constructor for kafka template
//5. Generate method to send message and object

//Here are the code snippets for the above steps:
//@Service
//public class JsonKafkaProducer {
//   private static final Logger LOGGER =  LoggerFactory.getLogger(JsonKafkaProducer.class);
//   private KafkaTemplate<String, String> kafkaTemplate;
//   public JsonKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
//       this.kafkaTemplate = kafkaTemplate;
//   }
//   public void sendMessage(String message) {
//       kafkaTemplate.send("library-events", message);
//   }
//}

