package sparta.scheduleservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sparta.scheduleservice.repository.dto.request.CreateNScheduleRequestDto;
import sparta.scheduleservice.repository.dto.response.CreateNScheduleResponseDto;
import sparta.scheduleservice.service.NScheduleService;

@Slf4j
@RestController
@RequestMapping("/nschedule")
@RequiredArgsConstructor
public class NScheduleController {

    private final NScheduleService nScheduleService;

    @PostMapping
    public CreateNScheduleResponseDto craete(@RequestBody CreateNScheduleRequestDto createNScheduleRequestDto) {
        return this.nScheduleService.createSchedule(createNScheduleRequestDto);
    }
}
