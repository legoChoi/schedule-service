package sparta.scheduleservice.repository.dto.schedule.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class FetchScheduleResponseDto {

    private int scheduleId;
    private String writer;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public FetchScheduleResponseDto() { }

    public FetchScheduleResponseDto(int scheduleId, String writer, String contents, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.scheduleId = scheduleId;
        this.writer = writer;
        this.contents = contents;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
