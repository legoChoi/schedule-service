package sparta.scheduleservice.repository.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateNScheduleRequestDto {

    private String userName;
    private String schedulePassword;
    private String title;
    private String contents;
}
