package com.cryptoinvestment.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Advice Exception Handler.
 *
 * @author maksim aleksandrov
 */
@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   * Exception handler
   * @param e Exception
   * @return ResponceEntiry
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleGenericException(Exception e) {
    return new ResponseEntity<>("Server error. Please, contact to administrator",
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * FileNotFoundException handler
   * @param e FileNotFoundException
   * @return ResponceEntiry
   */
  @ExceptionHandler(FileNotFoundException.class)
  public ResponseEntity<String> handleFileNotFoundException(FileNotFoundException e) {
    log.error(e.getMessage());
    return new ResponseEntity<>("There are no files by specified path",
        HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
