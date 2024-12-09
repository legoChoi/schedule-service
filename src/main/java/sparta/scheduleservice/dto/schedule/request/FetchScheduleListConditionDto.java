package sparta.scheduleservice.dto.schedule.request;

import lombok.Getter;

@Getter
public class FetchScheduleListConditionDto {

    private Integer userId;
    private String writer;
    private String updatedAt;
}