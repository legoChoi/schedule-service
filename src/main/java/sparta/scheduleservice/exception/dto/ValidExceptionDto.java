package sparta.scheduleservice.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ValidExceptionDto {
    private int code;
    private List<ValidFieldErrorDto> fieldErrors;
}


