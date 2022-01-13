package se.iths.springbootproject.jms.service;


import se.iths.springbootproject.jms.model.AccountMessage;


public interface JmsPublishService {
    String publishMessage(AccountMessage accountMessage);
}
