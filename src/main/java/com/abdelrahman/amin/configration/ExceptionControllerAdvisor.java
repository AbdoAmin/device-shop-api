package com.abdelrahman.amin.configration;

import com.abdelrahman.amin.dto.RestError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionControllerAdvisor {

    //TODO:Handel Each exception and response with descriptive error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestError> handelAllExceptions(Exception e, HttpServletRequest request) {
        RestError errorResponse
                = new RestError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), LocalDateTime.now(), request.getServletPath());
        return ResponseEntity.ok(errorResponse);
    }
}
