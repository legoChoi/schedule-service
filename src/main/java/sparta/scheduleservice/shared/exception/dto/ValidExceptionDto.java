package sparta.scheduleservice.shared.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class ValidExceptionDto {
    private int code;
    private List<FieldErrorDto> fieldErrors;
}


