package sparta.scheduleservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sparta.scheduleservice.dto.schedule.request.CreateScheduleRequestDto;
import sparta.scheduleservice.dto.schedule.request.DeleteScheduleRequestDto;
import sparta.scheduleservice.dto.schedule.request.FetchScheduleListConditionDto;
import sparta.scheduleservice.dto.schedule.request.UpdateScheduleRequestDto;
import sparta.scheduleservice.dto.schedule.response.CreateScheduleResponseDto;
import sparta.scheduleservice.dto.schedule.response.FetchScheduleResponseDto;
import sparta.scheduleservice.service.ScheduleService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/apis/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public CreateScheduleResponseDto createSchedule(
            @RequestBody CreateScheduleRequestDto createScheduleRequestDto
    ) {
        return this.scheduleService.createSchedule(createScheduleRequestDto);
    }

    @PatchMapping("/{scheduleId}")
    public int updateSchedule(
            @PathVariable("scheduleId") int scheduleId,
            @RequestBody UpdateScheduleRequestDto updateScheduleRequestDto
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
    public List<FetchScheduleResponseDto> fetchAll(
            FetchScheduleListConditionDto fetchScheduleListConditionDto
    ) {
        return this.scheduleService.fetchAll(fetchScheduleListConditionDto);
    }

    @DeleteMapping("/{scheduleId}")
    public int deleteSchedule(
            @PathVariable("scheduleId") int scheduleId,
            @RequestBody DeleteScheduleRequestDto deleteScheduleRequestDto
    ) {
        return this.scheduleService.deleteSchedule(scheduleId, deleteScheduleRequestDto);
    }
}