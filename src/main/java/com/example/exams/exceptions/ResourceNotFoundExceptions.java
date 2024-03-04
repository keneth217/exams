package com.example.exams.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptions extends RuntimeException {

    private final int status;

    public ResourceNotFoundExceptions(String message, int status) {
        super(message);
        this.status = status;
    }

}
