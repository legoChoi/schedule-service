package sparta.scheduleservice.repository.dto.request;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class CreateUserRequestDto {

    private String userName;
    private String userEmail;
}
