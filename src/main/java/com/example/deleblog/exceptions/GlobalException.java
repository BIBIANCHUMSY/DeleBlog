package com.example.deleblog.exceptions;

import com.example.deleblog.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(checkDetailsException.class)
    public ResponseEntity<String>checkDetailsException(checkDetailsException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(inValidPasswordException.class)
    public ResponseEntity<String>inValidPasswordException(inValidPasswordException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<String>UserExistsException(UserExistsException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(roleNotAllowedException.class)
    public ResponseEntity<String>roleNotAllowedException(roleNotAllowedException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PostNotAllowedException.class)
    public ResponseEntity<String>PostNotAllowedException(PostNotAllowedException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(illegalPostException.class)
    public ResponseEntity<String>illegalPostException(illegalPostException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPostException.class)
    public ResponseEntity<String>InvalidPostException(InvalidPostException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ApiResponse apiResponse = new ApiResponse("Invalid Request",errors, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
    }
}
