package com.testtask.test.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ErrorResponse {
    HttpStatus status;
    String message;
    LocalDateTime timestamp;

}
