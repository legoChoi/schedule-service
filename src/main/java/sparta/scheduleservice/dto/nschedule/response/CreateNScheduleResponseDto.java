package sparta.scheduleservice.dto.nschedule.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateNScheduleResponseDto {

    private int scheduleId;
    private String userName;
    private String schedulePassword;
    private String title;
    private String contents;

    public CreateNScheduleResponseDto(int scheduleId, String userName, String schedulePassword, String title, String contents) {
        this.scheduleId = scheduleId;
        this.userName = userName;
        this.schedulePassword = schedulePassword;
        this.title = title;
        this.contents = contents;
    }
}
