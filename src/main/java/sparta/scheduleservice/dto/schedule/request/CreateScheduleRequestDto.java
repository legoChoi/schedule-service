package sparta.scheduleservice.dto.schedule.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateScheduleRequestDto {

    @NotNull
    @Positive
    private Integer userId;

    @NotBlank @Size(min = 2, max = 10)
    private String schedulePassword;

    @NotBlank @Size(min = 2, max = 15)
    private String writer;

    @NotBlank @Size(min = 10, max = 200)
    private String contents;
}
