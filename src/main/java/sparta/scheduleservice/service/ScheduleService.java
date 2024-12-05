package sparta.scheduleservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sparta.scheduleservice.repository.ScheduleRepository;
import sparta.scheduleservice.repository.dto.request.CreateScheduleRequestDto;
import sparta.scheduleservice.repository.dto.response.CreateScheduleResponseDto;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public CreateScheduleResponseDto createSchedule(CreateScheduleRequestDto createScheduleRequestDto) {
        return this.scheduleRepository.save(createScheduleRequestDto);
    }
}
