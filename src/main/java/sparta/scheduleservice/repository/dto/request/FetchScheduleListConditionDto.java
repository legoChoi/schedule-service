package sparta.scheduleservice.repository.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FetchScheduleListConditionDto {
    private String userName;
    private String updatedAt;
}