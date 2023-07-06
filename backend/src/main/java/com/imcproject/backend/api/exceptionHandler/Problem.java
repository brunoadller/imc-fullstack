package com.imcproject.backend.api.exceptionHandler;

import lombok.Getter;
import lombok.Setter;

/**
 * Problem
 */
@Getter
@Setter
public class Problem {

  private Integer status;
  private String title;
  private String message;
  private String name;
}