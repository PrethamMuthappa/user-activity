package org.example.producer.Controller;
import org.example.producer.Service.KafkaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final KafkaService kafkaService;

    public HomeController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("/check")
    public void checkforclicks(){
       kafkaService.checkmessage();
    }
}
