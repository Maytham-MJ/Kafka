package net.javaguides.springbootkafkatutorial.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {


    private static final Logger LOGGER =  LoggerFactory.getLogger(KafkaProducer.class); // This is the logger for this class.



    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info(String.format("$$ -> Producing message --> %s", message));
        kafkaTemplate.send("library-events", message);
    }
}


// To set up Kafka in your local machine, follow the steps below:
// 1. Download the latest version of Kafka from https://kafka.apache.org/downloads
// 2. Extract the downloaded file and navigate to the extracted folder.
// 3. Start Zookeeper server by running the following command:
// bin/zookeeper-server-start.sh config/zookeeper.properties
// 4. Start Kafka server by running the following command:
// bin/kafka-server-start.sh config/server.properties
// 5. Create a topic named library-events by running the following command:
// bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic library-events
// 6. Start a consumer to listen to the topic library-events by running the following command:
// bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic library-events --from-beginning
// 7. Start a producer to send messages to the topic library-events by running the following command:
// bin/kafka-console-producer.sh --broker-list localhost:9092 --topic library-events
// 8. Now, you can send messages to the topic library-events from the producer console and see the messages in the consumer console.
// 9. To stop the Kafka server, run the following command:
// bin/kafka-server-stop.sh
// 10. To stop the Zookeeper server, run the following command:
// bin/zookeeper-server-stop.sh







// How to create a Kafka topic in Spring Boot?
// To create a Kafka topic in Spring Boot, you need to create a bean of type NewTopic in the KafkaTopicConfig class.
// The following code snippet shows how to create a Kafka topic in Spring Boot:
// @Configuration
// public class KafkaTopicConfig {}
// Inside the KafkaTopicConfig class, create a bean of type NewTopic as shown below:
// @Bean
// public NewTopic libraryEvents(){
//     return TopicBuilder.name("library-events")
//         .build();
// }
// The above code snippet creates a Kafka topic named library-events.
// The TopicBuilder class is used to create a topic in Kafka.
// The name() method is used to set the name of the topic.
// The build() method is used to build the topic.
// The following code snippet shows how to create a Kafka topic with multiple partitions and replication factor:
// @Bean
// public NewTopic libraryEvents(){
//     return TopicBuilder.name("library-events")
//         .partitions(3)
//         .replicas(3)
//         .build();
// }
// The partitions() method is used to set the number of partitions for the topic.
// The replicas() method is used to set the replication factor for the topic.
// The following code snippet shows how to create a Kafka topic with a custom configuration:
// @Bean
// public NewTopic libraryEvents(){
//     Map<String, String> configs = new HashMap<>();
//     configs.put("cleanup.policy", "compact");
//     configs.put("min.compaction.lag.ms", "10000");
//     configs.put("segment.ms", "10000");
//     return TopicBuilder.name("library-events")
//         .assignReplicas(1)
//         .config(configs)
//         .build();
// }
// The assignReplicas() method is used to set the number of replicas for the topic.
// The config() method is used to set the custom configuration for the topic.
// Create the next step in the tutorial: Kafka Producer









// How to create a Kafka producer in Spring Boot?
//First create package net.javaguides.springbootkafkatutorial.kafka
// Then create package called Kafka.
// Then create a class called KafkaProducer.java
// To create a Kafka producer in Spring Boot, you need to create a bean of type KafkaTemplate in the KafkaProducer class.
// The following code snippet shows how to create a Kafka producer in Spring Boot:
// @Service
// public class KafkaProducer {}
// Inside the KafkaProducer class, create a bean of type KafkaTemplate as shown below:
// private KafkaTemplate<String, String> kafkaTemplate;
// public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
//     this.kafkaTemplate = kafkaTemplate;
// }
// The above code snippet creates a Kafka producer.
// The KafkaTemplate class is used to send messages to Kafka topics.
// The following code snippet shows how to send messages to a Kafka topic using the KafkaTemplate class:
// public void sendMessage(String message) {
//     kafkaTemplate.send("library-events", message);
// }
// Create Logger for this class.
// private static final Logger LOGGER =  LoggerFactory.getLogger(KafkaProducer.class); // This is the logger for this class.
// The following code snippet shows how to log messages in the KafkaProducer class:
// LOGGER.info(String.format("$$ -> Producing message --> %s", message));
// The above code snippet logs the message that is sent to the Kafka topic.




//Create Kafka Consumer in Spring Boot
// To create a Kafka consumer in Spring Boot, you need to create a bean of type KafkaListenerContainerFactory in the KafkaConsumer class.
// The following code snippet shows how to create a Kafka consumer in Spring Boot:
// @Service // This annotation indicates that an annotated class is a "Service" spring bean.
// public class KafkaConsumer {}
// Inside the KafkaConsumer class, create a bean of type KafkaListenerContainerFactory as shown below:
// @KafkaListener(topics = "library-events" , groupId = "myGroup")
// public void onMessage(String message){
//     System.out.println("Consumed message: " + message);
// }
// The above code snippet creates a Kafka consumer.



