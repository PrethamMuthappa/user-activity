package org.example.producer.Config;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    @Bean
    public NewTopic topics(){
        return new NewTopic("no_of_visits", 1, (short) 1);
    }

    @Bean
    public NewTopic topic1(){
        return TopicBuilder.name("button_clicked")
                .partitions(1)
                .replicas(1)
                .compact()
                .build();
    }
}
