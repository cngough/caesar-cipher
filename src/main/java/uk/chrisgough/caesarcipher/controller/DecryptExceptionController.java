package uk.chrisgough.caesarcipher.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uk.chrisgough.caesarcipher.model.CommonErrorResponse;
import uk.chrisgough.caesarcipher.exception.FailedToDecipherException;

@ControllerAdvice
public class DecryptExceptionController {

    @ExceptionHandler(value = FailedToDecipherException.class)
    public ResponseEntity<CommonErrorResponse> exception(FailedToDecipherException exception) {

        CommonErrorResponse response = new CommonErrorResponse(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
