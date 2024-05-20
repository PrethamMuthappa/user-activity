package org.example.consumer.Service;

import lombok.extern.slf4j.Slf4j;
import org.example.consumer.Model.KafkaModel;
import org.example.consumer.Repo.KafkaDB;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Slf4j
@Service
public class Listner {
    private final KafkaDB kafkaDB;
    public Listner(KafkaDB kafkaDB) {
        this.kafkaDB = kafkaDB;
    }
    @KafkaListener(topics = "no_of_visits",groupId = "user")
    public void listen(String message)
    {
      log.info(message);
      try{
          KafkaModel model=new KafkaModel();
          model.setCount(message);
          model.setView_Time(LocalDateTime.now());
          kafkaDB.save(model);
      }
      catch (Exception e){
          log.error(e.getMessage());
      }
    }

}
