package com.imcproject.backend.api.exceptionHandler;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.imcproject.backend.domain.exception.VerifyException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  private MessageSource messageSource;

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatusCode status, WebRequest request) {
    Problem problem = new Problem();

    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
      // fazendo o casting consegue-se pegar o campo do erro e seu nome
      String name = ((FieldError) error).getField();
      String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

      problem.setName(name);
      problem.setMessage(message);
    }
    problem.setStatus(status.value());
    problem.setTitle(
        "Um ou mais campos estão inválidos Faça o preenchimento correto e tente novamente.");

    return handleExceptionInternal(ex, problem, headers, status, request);
  }

  @ExceptionHandler(VerifyException.class)
  public ResponseEntity<Object> handleVerify(VerifyException ex, WebRequest request) {
    // para passar o status
    HttpStatus status = HttpStatus.NOT_FOUND;

    Problem problem = new Problem();
    // pegando o status do tratamento
    problem.setStatus(status.value());
    // seta a mensagem de aviso
    problem.setTitle(
        ex.getMessage());

    return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
  }

}
