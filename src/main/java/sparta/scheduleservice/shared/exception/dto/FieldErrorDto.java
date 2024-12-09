package sparta.scheduleservice.shared.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class FieldErrorDto {
    private String field;
    private Object input;
    private String message;
}
