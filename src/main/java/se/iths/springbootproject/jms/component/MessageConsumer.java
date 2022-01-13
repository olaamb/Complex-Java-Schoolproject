package se.iths.springbootproject.jms.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import se.iths.springbootproject.jms.model.AccountMessage;

import java.util.ArrayList;
import java.util.List;


@Component
public class MessageConsumer {

//    public static List<AccountMessage> list = new ArrayList<>();
//    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);
//
//
//    @JmsListener(destination = "MESSAGE_QUEUE")
//    public void messageListener(AccountMessage accountMessage) {
//        LOGGER.info("Message received! {}", accountMessage);
//        list.add(accountMessage);
//    }
}
