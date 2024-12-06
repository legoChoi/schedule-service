package sparta.scheduleservice.dto.user.request;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class CreateUserRequestDto {

    private String userName;
    private String userEmail;
}
