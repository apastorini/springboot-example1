package com.gofore.grandma.controller;


import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gofore.grandma.exception.ReceipeNotFoundException;

@ControllerAdvice
class ReceipeControlAdvice {

 

  
  @ResponseBody
  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  String handleConstraintViolationException(ConstraintViolationException e) {
      return "Validation error: " + e.getMessage();
  }
}