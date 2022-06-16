package io.ze.controller.advice;

import io.ze.dto.ExceptionData;
import io.ze.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionData handleApplicationException(final ApplicationException applicationException) {
        log.error("Erreur", applicationException);
        final ExceptionData exceptionData = new ExceptionData();
        exceptionData.setTimestamp(LocalDateTime.now());
        exceptionData.setMessage(applicationException.getMessage());
        return exceptionData;

    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionData handleIllegalArgumentException(final IllegalArgumentException exception) {
        log.error("Erreur", exception);
        final ExceptionData exceptionData = new ExceptionData();
        exceptionData.setTimestamp(LocalDateTime.now());
        exceptionData.setMessage(exception.getMessage());
        return exceptionData;
    }

}
