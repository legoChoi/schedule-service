package sparta.scheduleservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sparta.scheduleservice.repository.dto.request.CreateScheduleRequestDto;
import sparta.scheduleservice.repository.dto.request.FetchScheduleListConditionDto;
import sparta.scheduleservice.repository.dto.response.CreateScheduleResponseDto;
import sparta.scheduleservice.repository.dto.response.FetchScheduleResponseDto;
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

    @GetMapping("/{scheduleId}")
    public FetchScheduleResponseDto fetchOne(@PathVariable("scheduleId") int scheduleId) {
        return this.scheduleService.fetchOne(scheduleId);
    }

    @GetMapping
    public List<FetchScheduleResponseDto> fetchAll(FetchScheduleListConditionDto fetchScheduleListConditionDto) {
        return this.scheduleService.fetchAll(fetchScheduleListConditionDto);
    }
}
