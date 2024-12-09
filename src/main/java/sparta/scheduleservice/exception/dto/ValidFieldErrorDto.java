package sparta.scheduleservice.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ValidFieldErrorDto {
    private String field;
    private Object input;
    private String message;
}
