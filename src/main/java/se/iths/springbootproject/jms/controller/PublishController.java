package se.iths.springbootproject.jms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.iths.springbootproject.jms.model.AccountMessage;

import javax.jms.Queue;


@RestController
public class PublishController {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    Queue queue;


    @PostMapping("/publishmessage")
    public ResponseEntity<String> publishMessage(@RequestBody AccountMessage accountMessage) {
        try {
            jmsTemplate.convertAndSend(queue, accountMessage);
            return new ResponseEntity<>("The message has successfully Sent!", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
