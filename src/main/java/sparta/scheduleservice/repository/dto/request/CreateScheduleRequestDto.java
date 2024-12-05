package sparta.scheduleservice.repository.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateScheduleRequestDto {

    private int userId;
    private String schedulePassword;
    private String writer;
    private String contents;
}
