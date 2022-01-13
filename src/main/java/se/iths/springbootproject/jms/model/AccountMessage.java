package se.iths.springbootproject.jms.model;

import java.io.Serializable;

public class AccountMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

    public AccountMessage() {
    }

    public AccountMessage(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AccountMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
