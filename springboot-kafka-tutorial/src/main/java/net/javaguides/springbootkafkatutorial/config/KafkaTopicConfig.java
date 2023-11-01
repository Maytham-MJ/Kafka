package net.javaguides.springbootkafkatutorial.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration // This annotation indicates that this class contains one or more bean methods annotated with @Bean producing beans manageable by spring container.
public class KafkaTopicConfig {

    @Bean //To make it as spring bean
    public NewTopic libraryEvents(){
        return TopicBuilder.name("library-events")

            .build();
    }


}
