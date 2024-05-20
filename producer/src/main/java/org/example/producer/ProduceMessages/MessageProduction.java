package org.example.producer.ProduceMessages;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import java.util.concurrent.CompletableFuture;

@Component
public class MessageProduction {

    private final KafkaTemplate<String, String>kafkaTemplate;

    public MessageProduction(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    private static int count;

    public void sendmessage() {
        count++;
        CompletableFuture<SendResult<String,String>>future=this.kafkaTemplate.send("no_of_visits", "No of people visited this route is"+count);
        try {
            future.whenComplete((res,ex)->{
               if(ex==null){
                   System.out.println("done"+ res.getProducerRecord());
               }
               else {
                   System.out.println("error"+ ex.getMessage());
               }
            });
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
