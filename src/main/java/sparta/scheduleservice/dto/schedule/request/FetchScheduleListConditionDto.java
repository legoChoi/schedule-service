package sparta.scheduleservice.dto.schedule.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FetchScheduleListConditionDto {

    private Integer userId;
    private String writer;
    private String updatedAt;
}