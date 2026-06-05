package edu.inMemorySecurity.Advice;

import edu.inMemorySecurity.Exception.User.RestUserErrorRespose;
import edu.inMemorySecurity.Exception.User.UserDatabaseAlreadyClearException;
import edu.inMemorySecurity.Exception.User.UsernameAlreadyInUseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestUserExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsernameAlreadyInUseException.class)
    public ResponseEntity<RestUserErrorRespose> UsernameAlreadyInUse(UsernameAlreadyInUseException exception){
        RestUserErrorRespose errorRespose = new RestUserErrorRespose(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespose);
    }

    @ExceptionHandler(UserDatabaseAlreadyClearException.class)
    public ResponseEntity<RestUserErrorRespose> UserDatabaseAlreadyClear(UserDatabaseAlreadyClearException exception){
        RestUserErrorRespose errorRespose = new RestUserErrorRespose(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespose);
    }

}
