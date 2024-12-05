package sparta.scheduleservice.repository.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class FetchScheduleResponseDto {

    private int scheduleId;
    private String userName;
    private String title;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public FetchScheduleResponseDto() { }

    public FetchScheduleResponseDto(int scheduleId, String userName, String title, String contents, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.scheduleId = scheduleId;
        this.userName = userName;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
