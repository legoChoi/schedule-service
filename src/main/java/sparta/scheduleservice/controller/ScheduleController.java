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
import sparta.scheduleservice.service.schedule.ScheduleServiceImpl;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/apis/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleServiceImpl scheduleService;

    /**
     * 일정 생성
     * @param createScheduleRequestDto
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
     */
    @GetMapping("/{scheduleId}")
    public ResponseEntity<FetchScheduleResponseDto> fetchOne(
            @PathVariable("scheduleId") int scheduleId
    ) {
        FetchScheduleResponseDto data = this.scheduleService.fetchOne(scheduleId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(data);
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
        List<FetchScheduleResponseDto> data = this.scheduleService.fetchAll(fetchScheduleListConditionDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(data);
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
        List<FetchScheduleResponseDto> data = this.scheduleService.paginateSchedule(paginateRequestDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(data);
    }
}