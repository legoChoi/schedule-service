package sparta.scheduleservice.shared.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sparta.scheduleservice.shared.exception.dto.FieldErrorDto;
import sparta.scheduleservice.shared.exception.dto.ValidExceptionDto;

import java.util.List;

@RestControllerAdvice
public class ValidExceptionControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ValidExceptionDto> checkValidRequestArgs(MethodArgumentNotValidException e) {

        List<FieldErrorDto> fieldErrors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new FieldErrorDto(
                        fieldError.getField(),
                        fieldError.getRejectedValue(),
                        fieldError.getDefaultMessage()
                ))
                .toList();

        ValidExceptionDto validExceptionDto = new ValidExceptionDto(e.getStatusCode().value(), fieldErrors);

        return ResponseEntity
                .badRequest()
                .body(validExceptionDto);
    }
}
