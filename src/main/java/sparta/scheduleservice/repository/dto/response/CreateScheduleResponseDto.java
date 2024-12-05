package sparta.scheduleservice.repository.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateScheduleResponseDto {

    private int scheduleId;
    private int userId;
    private String schedulePassword;
    private String title;
    private String contents;

    public CreateScheduleResponseDto(int scheduleId, int userId, String schedulePassword, String title, String contents) {
        this.scheduleId = scheduleId;
        this.userId = userId;
        this.schedulePassword = schedulePassword;
        this.title = title;
        this.contents = contents;
    }
}
