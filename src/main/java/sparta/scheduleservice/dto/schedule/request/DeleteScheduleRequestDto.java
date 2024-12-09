package sparta.scheduleservice.dto.schedule.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DeleteScheduleRequestDto {

    @NotBlank
    private String schedulePassword;
}
