package sparta.scheduleservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sparta.scheduleservice.repository.dto.schedule.request.CreateScheduleRequestDto;
import sparta.scheduleservice.repository.dto.schedule.request.FetchScheduleListConditionDto;
import sparta.scheduleservice.repository.dto.schedule.request.UpdateScheduleRequestDto;
import sparta.scheduleservice.repository.dto.schedule.response.CreateScheduleResponseDto;
import sparta.scheduleservice.repository.dto.schedule.response.FetchScheduleResponseDto;
import sparta.scheduleservice.service.ScheduleService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public CreateScheduleResponseDto createSchedule(@RequestBody CreateScheduleRequestDto createScheduleRequestDto) {
        return this.scheduleService.createSchedule(createScheduleRequestDto);
    }

    @PatchMapping("/{scheduleId}")
    public int updateSchedule(@PathVariable("scheduleId") int scheduleId, @RequestBody UpdateScheduleRequestDto updateScheduleRequestDto) {
        return this.scheduleService.updateSchedule(scheduleId, updateScheduleRequestDto);
    }

    @GetMapping("/{scheduleId}")
    public FetchScheduleResponseDto fetchOne(@PathVariable("scheduleId") int scheduleId) {
        return this.scheduleService.fetchOne(scheduleId);
    }

    @GetMapping
    public List<FetchScheduleResponseDto> fetchAll(FetchScheduleListConditionDto fetchScheduleListConditionDto) {
        return this.scheduleService.fetchAll(fetchScheduleListConditionDto);
    }
}