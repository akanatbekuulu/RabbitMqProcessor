package edu.akanatbekuulu.rabbitmqprocessor.controller;


import edu.akanatbekuulu.rabbitmqprocessor.entities.Message;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/publisher")
@Tag(name = "PUBLISHER_API")
public class MessageController {


    @GetMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestParam("message") Message message){
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }


}
