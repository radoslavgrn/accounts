package com.assignment.accounts.exceptions;

import com.assignment.accounts.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {


  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ApiError> handleNotFoundException(
      NotFoundException ex
  ) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value()));
  }

  private ApiError buildErrorResponse(String message, int value) {
    ApiError error = new ApiError();
    error.setCode(String.valueOf(value));
    error.setMessage(message);

    return error;
  }
}
