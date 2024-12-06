package sparta.scheduleservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sparta.scheduleservice.repository.NScheduleRepository;
import sparta.scheduleservice.dto.nschedule.request.CreateNScheduleRequestDto;
import sparta.scheduleservice.dto.nschedule.response.CreateNScheduleResponseDto;

@Service
@RequiredArgsConstructor
public class NScheduleService {

    private final NScheduleRepository nScheduleRepository;

    public CreateNScheduleResponseDto createSchedule(CreateNScheduleRequestDto createNScheduleRequestDto) {
        return this.nScheduleRepository.save(createNScheduleRequestDto);
    }
}