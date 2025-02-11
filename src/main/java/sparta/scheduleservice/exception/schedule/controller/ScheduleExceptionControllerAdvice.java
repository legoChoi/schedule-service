package sparta.scheduleservice.exception.schedule.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sparta.scheduleservice.controller.ScheduleController;
import sparta.scheduleservice.exception.dto.ExceptionDto;
import sparta.scheduleservice.exception.schedule.exception.exceptions.PasswordMismatchException;
import sparta.scheduleservice.exception.schedule.exception.exceptions.ScheduleNotFoundException;

@RestControllerAdvice(assignableTypes = ScheduleController.class)
public class ScheduleExceptionControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ExceptionDto> passwordMismatchException(PasswordMismatchException e) {
        ExceptionDto exceptionDto = new ExceptionDto(HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exceptionDto);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDto> emptyScheduleException(ScheduleNotFoundException e) {
        ExceptionDto exceptionDto = new ExceptionDto(HttpStatus.NOT_FOUND.value(), e.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionDto);
    }
}
