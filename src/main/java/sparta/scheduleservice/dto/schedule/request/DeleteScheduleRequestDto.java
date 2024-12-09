package sparta.scheduleservice.dto.schedule.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class DeleteScheduleRequestDto {

    @NotBlank
    private String schedulePassword;
}
