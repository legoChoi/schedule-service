package sparta.scheduleservice.dto.schedule.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class FetchScheduleResponseDto {

    private int scheduleId;
    private String writer;
    private String userName;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
