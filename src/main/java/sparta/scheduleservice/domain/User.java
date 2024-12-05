package sparta.scheduleservice.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class User {

    private int userId;
    private String userName;
    private String userEmail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
