package sparta.scheduleservice.repository.dto.user.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateUserResponseDto {

    private int userId;
    private String userName;
    private String userEmail;

    public CreateUserResponseDto(int userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }
}
