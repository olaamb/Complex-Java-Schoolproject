package se.iths.springbootproject.jms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import se.iths.springbootproject.jms.model.AccountMessage;

import javax.jms.Queue;

@Service
public class JmsPublishServiceImpl implements JmsPublishService {

    private JmsTemplate jmsTemplate;

    @Override
    public String publishMessage(AccountMessage accountMessage) {
        try {
            jmsTemplate.convertAndSend("MESSAGE_QUEUE", accountMessage);
            return "successfully Sent!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
