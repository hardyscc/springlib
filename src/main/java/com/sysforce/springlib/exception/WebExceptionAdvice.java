package com.sysforce.springlib.exception;

import com.sysforce.springlib.exception.impl.BadRequestException;
import com.sysforce.springlib.exception.impl.ConflictException;
import com.sysforce.springlib.exception.impl.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class WebExceptionAdvice {

    @ResponseBody
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorMessage notFoundHandler(NotFoundException ex) {
        return new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new String[]{ex.getMessage()},
                HttpStatus.NOT_FOUND.getReasonPhrase());
    }

    @ResponseBody
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorMessage badRequestHandler(BadRequestException ex) {
        return new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                new String[]{ex.getMessage()},
                HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @ResponseBody
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    ErrorMessage conflictHandler(ConflictException ex) {
        return new ErrorMessage(
                HttpStatus.CONFLICT.value(),
                new String[]{ex.getMessage()},
                HttpStatus.CONFLICT.getReasonPhrase());
    }

    @ResponseBody
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorMessage illegalArgumentExceptionHandler(IllegalArgumentException ex) {
        return new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                new String[]{ex.getMessage()},
                HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @ResponseBody
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorMessage methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        return new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                ex.getFieldErrors().stream().map((error) ->
                        String.format("%s : %s",
                                error.getField(),
                                error.getDefaultMessage()
                        )).toArray(String[]::new),
                HttpStatus.BAD_REQUEST.getReasonPhrase());
    }
}