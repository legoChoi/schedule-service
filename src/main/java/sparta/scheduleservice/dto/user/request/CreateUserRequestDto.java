package sparta.scheduleservice.dto.user.request;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateUserRequestDto {

    @NotBlank @Size(min = 3, max = 10)
    private String userName;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "올바른 이메일 형식이 아닙니다.")
    private String userEmail;
}
