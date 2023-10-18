package com.testtask.test.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Arrays;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequestException(final Exception e) {
        log.error("Error stack trace: {}", Arrays.toString(e.getStackTrace()));
        return new ErrorResponse(HttpStatus.BAD_REQUEST,
                e.getMessage(),
                LocalDateTime.now());
    }
}
