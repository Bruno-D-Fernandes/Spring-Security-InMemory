package edu.inMemorySecurity.Exception.User;

import org.springframework.http.HttpStatus;

public record RestUserErrorRespose(HttpStatus httpStatus, String message)
{
}
