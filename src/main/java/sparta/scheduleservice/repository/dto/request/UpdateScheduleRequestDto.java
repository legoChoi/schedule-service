package sparta.scheduleservice.repository.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateScheduleRequestDto {

    private String schedulePassword;
    private String contents;
    private String writer;
}
