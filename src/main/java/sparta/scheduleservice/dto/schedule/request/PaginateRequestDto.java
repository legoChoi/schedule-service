package sparta.scheduleservice.dto.schedule.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PaginateRequestDto {
    @PositiveOrZero private int page;
    @Positive private int size;
}
