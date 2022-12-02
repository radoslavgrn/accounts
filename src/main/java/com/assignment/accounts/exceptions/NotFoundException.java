package com.assignment.accounts.exceptions;

public class NotFoundException extends RuntimeException {

  public NotFoundException(Integer id) {
    super(getMessage(id));
  }

  private static String getMessage(Integer id) {
    return String.format("Resource with id %s not found", id);
  }
}