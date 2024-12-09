package sparta.scheduleservice.controller.schedule;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sparta.scheduleservice.dto.schedule.request.*;
import sparta.scheduleservice.dto.schedule.response.CreateScheduleResponseDto;
import sparta.scheduleservice.dto.schedule.response.FetchScheduleResponseDto;
import sparta.scheduleservice.service.schedule.ScheduleService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/apis/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public CreateScheduleResponseDto createSchedule(
            @Valid @RequestBody CreateScheduleRequestDto createScheduleRequestDto
    ) {
        return this.scheduleService.createSchedule(createScheduleRequestDto);
    }

    @PatchMapping("/{scheduleId}")
    public int updateSchedule(
            @Positive @PathVariable("scheduleId") int scheduleId,
            @Valid @RequestBody UpdateScheduleRequestDto updateScheduleRequestDto
    ) {
        return this.scheduleService.updateSchedule(scheduleId, updateScheduleRequestDto);
    }

    @GetMapping("/{scheduleId}")
    public FetchScheduleResponseDto fetchOne(
            @PathVariable("scheduleId") int scheduleId
    ) {
        return this.scheduleService.fetchOne(scheduleId);
    }

    @GetMapping
    public ResponseEntity<List<FetchScheduleResponseDto>> fetchAll(
            FetchScheduleListConditionDto fetchScheduleListConditionDto
    ) {
        return this.scheduleService.fetchAll(fetchScheduleListConditionDto);
    }

    @DeleteMapping("/{scheduleId}")
    public int deleteSchedule(
            @PathVariable("scheduleId") int scheduleId,
            @Valid @RequestBody DeleteScheduleRequestDto deleteScheduleRequestDto
    ) {
        return this.scheduleService.deleteSchedule(scheduleId, deleteScheduleRequestDto);
    }

    @GetMapping("/paginate")
    public ResponseEntity<List<FetchScheduleResponseDto>> paginateSchedule(
            @Valid PaginateRequestDto paginateRequestDto
    ) {
        return this.scheduleService.paginateSchedule(paginateRequestDto);
    }
}