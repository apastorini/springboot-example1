package com.gofore.grandma.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gofore.grandma.model.Ingredients;
import com.gofore.grandma.model.Receipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@AllArgsConstructor
public class BusinessException extends Exception {
 
 private String code;
 private String message;
 
 
}
