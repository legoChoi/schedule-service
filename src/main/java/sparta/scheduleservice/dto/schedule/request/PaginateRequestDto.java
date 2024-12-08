package sparta.scheduleservice.dto.schedule.request;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PaginateRequestDto {
    @Positive private int page;
    @Positive private int size;
}
