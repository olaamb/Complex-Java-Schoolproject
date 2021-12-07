package se.iths.springbootproject.exception;

public class ListNotFoundOrEmptyException extends RuntimeException {
    public ListNotFoundOrEmptyException(String message) {
        super(message);
    }
}
