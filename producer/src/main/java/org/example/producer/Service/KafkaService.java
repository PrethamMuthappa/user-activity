package org.example.producer.Service;

import org.example.producer.ProduceMessages.MessageProduction;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private final MessageProduction messageProduction;
    public Object checkmessage;

    public KafkaService(MessageProduction messageProduction) {
        this.messageProduction = messageProduction;
    }

    public void checkmessage(){
        messageProduction.sendmessage();
    }
}
