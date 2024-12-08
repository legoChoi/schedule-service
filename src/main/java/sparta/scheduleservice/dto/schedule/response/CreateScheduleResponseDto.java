package sparta.scheduleservice.dto.schedule.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CreateScheduleResponseDto {

    private int scheduleId;
    private int userId;
    private String schedulePassword;
    private String writer;
    private String contents;
}
