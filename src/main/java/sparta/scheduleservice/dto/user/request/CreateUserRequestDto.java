package sparta.scheduleservice.dto.user.request;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateUserRequestDto {

    @NotNull @NotBlank @Size(min = 3, max = 10)
    private String userName;

    @NotNull @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String userEmail;
}
