package sparta.scheduleservice.dto.user.request;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DeleteUserReqDto {

    @Positive
    private int userId;
}
