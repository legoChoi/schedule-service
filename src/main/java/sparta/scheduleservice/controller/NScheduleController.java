package sparta.scheduleservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sparta.scheduleservice.dto.nschedule.request.CreateNScheduleRequestDto;
import sparta.scheduleservice.dto.nschedule.response.CreateNScheduleResponseDto;
import sparta.scheduleservice.service.nschedule.NScheduleServiceImpl;

@Slf4j
@RestController
@RequestMapping("/apis/nschedule")
@RequiredArgsConstructor
public class NScheduleController {

    private final NScheduleServiceImpl nScheduleService;

    @PostMapping
    public CreateNScheduleResponseDto createNSchedule(
            @RequestBody CreateNScheduleRequestDto createNScheduleRequestDto
    ) {
        return this.nScheduleService.createSchedule(createNScheduleRequestDto);
    }
}
