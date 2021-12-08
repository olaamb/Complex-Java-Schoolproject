package se.iths.springbootproject.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    // CUSTOM EXCEPTION
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException ex) {
        String errorMessage = "Entity not found.";

        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, errorMessage, ex));
    }

    @ExceptionHandler({ListNotFoundOrEmptyException.class})
    public ResponseEntity<Object> listNotFoundException(ListNotFoundOrEmptyException ex) {
        String errorMessage = "List not found.";

        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, errorMessage, ex));
    }

    @ExceptionHandler({EntityAlreadyExistsException.class})
    public ResponseEntity<Object> entityAlreadyExistsException(EntityAlreadyExistsException ex) {
        String errorMessage = "Account name is already in use.";

        return  buildResponseEntity(new ApiError(HttpStatus.FORBIDDEN, errorMessage, ex));
    }


    // BASE EXCEPTIONS
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorMessage = "Malformed JSON request.";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, errorMessage, ex));
    }

    // TODO: Check how to allow request methods on Java method level
//    @Override
//    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
//            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        logger.info(ex.getClass().getName());
//        StringBuilder builder = new StringBuilder();
//        builder.append(ex.getMethod());
//        builder.append(" method is not supported for this request. Supported methods are ");
//        Objects.requireNonNull(ex.getSupportedHttpMethods()).forEach(t -> builder.append(t + " "));
//
//        return buildResponseEntity(new ApiError(HttpStatus.METHOD_NOT_ALLOWED, builder.toString(), ex));
//    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        String errorMessage = "An unexpected error occurred.";

        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage, ex));
    }





}
