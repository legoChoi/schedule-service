package sparta.scheduleservice.dto.schedule.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateScheduleRequestDto {

    @NotBlank
    private String schedulePassword;

    @NotBlank @Size(min = 10, max = 200)
    private String contents;

    @NotBlank @Size(min = 2, max = 15)
    private String writer;
}
