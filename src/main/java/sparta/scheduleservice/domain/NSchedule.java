package sparta.scheduleservice.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NSchedule {

    private int scheduleId;
    private String userName;
    private String schedulePassword;
    private String title;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
