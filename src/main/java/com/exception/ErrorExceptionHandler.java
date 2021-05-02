package com.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@ControllerAdvice
public class ErrorExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler({BaseException.class})
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, BaseException rex, Locale locale) {
        HttpStatus status = HttpStatus.valueOf(403);
        String errorMessage = messageSource.getMessage(rex.getErrorMsg(), rex.getParamList(), locale);
        return new ResponseEntity<>(new ErrorResponse(errorMessage), status);
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    ResponseEntity<?> defaultErrorHandler(HttpServletRequest request, Exception rex, Locale locale) {
        rex.printStackTrace();
        HttpStatus status = HttpStatus.valueOf(500);
        String errorMessage = messageSource.getMessage("server.error", new Object[]{rex.getMessage()}, locale);
        return new ResponseEntity<>(new ErrorResponse(errorMessage), status);
    }
}
