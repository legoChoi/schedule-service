package sparta.scheduleservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sparta.scheduleservice.dto.schedule.request.*;
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

    /**
     * 일정 생성
     * @param createScheduleRequestDto
     * @return
     */
    @PostMapping
    public ResponseEntity<CreateScheduleResponseDto> createSchedule(
            @Valid @RequestBody CreateScheduleRequestDto createScheduleRequestDto
    ) {
        CreateScheduleResponseDto data = this.scheduleService.createSchedule(createScheduleRequestDto);

        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(data);
    }

    /**
     * 일정 수정
     * @param scheduleId
     * @param updateScheduleRequestDto
     * @return
     */
    @PatchMapping("/{scheduleId}")
    public int updateSchedule(
            @PathVariable("scheduleId") int scheduleId,
            @Valid @RequestBody UpdateScheduleRequestDto updateScheduleRequestDto
    ) {
        return this.scheduleService.updateSchedule(scheduleId, updateScheduleRequestDto);
    }

    /**
     * 일정 조회 (단건)
     * @param scheduleId
     * @return
     */
    @GetMapping("/{scheduleId}")
    public ResponseEntity<FetchScheduleResponseDto> fetchOne(
            @PathVariable("scheduleId") int scheduleId
    ) {
        return this.scheduleService.fetchOne(scheduleId);
    }

    /**
     * 일정 조회 (목록)
     * @param fetchScheduleListConditionDto
     * @return
     */
    @GetMapping
    public ResponseEntity<List<FetchScheduleResponseDto>> fetchAll(
            FetchScheduleListConditionDto fetchScheduleListConditionDto
    ) {
        return this.scheduleService.fetchAll(fetchScheduleListConditionDto);
    }

    /**
     * 일정 삭제
     * @param scheduleId
     * @param deleteScheduleRequestDto
     * @return
     */
    @DeleteMapping("/{scheduleId}")
    public int deleteSchedule(
            @PathVariable("scheduleId") int scheduleId,
            @Valid @RequestBody DeleteScheduleRequestDto deleteScheduleRequestDto
    ) {
        return this.scheduleService.deleteSchedule(scheduleId, deleteScheduleRequestDto);
    }

    /**
     * 일정 조회 (목록 - 페이지네이션)
     * @param paginateRequestDto
     * @return
     */
    @GetMapping("/paginate")
    public ResponseEntity<List<FetchScheduleResponseDto>> paginateSchedule(
            @Valid PaginateRequestDto paginateRequestDto
    ) {
        return this.scheduleService.paginateSchedule(paginateRequestDto);
    }
}