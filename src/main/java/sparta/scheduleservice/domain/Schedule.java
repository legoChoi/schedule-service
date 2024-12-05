package sparta.scheduleservice.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Schedule {

    private int scheduleId;
    private int userId;
    private String schedulePW;
    private String title;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
