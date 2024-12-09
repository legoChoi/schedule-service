package sparta.scheduleservice.dto.schedule.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PaginateRequestDto {

    @NotNull @PositiveOrZero
    private Integer page;
    @NotNull @Positive
    private Integer size;
}
