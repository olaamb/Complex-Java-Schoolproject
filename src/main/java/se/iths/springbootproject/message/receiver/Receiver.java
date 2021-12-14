package se.iths.springbootproject.message.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import se.iths.springbootproject.message.config.JmsConfig;
import se.iths.springbootproject.message.model.MessageObject;

@Component
public class Receiver {

    @JmsListener(destination = JmsConfig.JU20_QUEUE)
    public void listen(@Payload MessageObject messageObject) {
        System.out.println("I got a message");
        System.out.println(messageObject);
    }

}
