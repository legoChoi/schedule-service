package sparta.scheduleservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sparta.scheduleservice.repository.NScheduleRepository;
import sparta.scheduleservice.repository.dto.request.CreateNScheduleRequestDto;
import sparta.scheduleservice.repository.dto.response.CreateNScheduleResponseDto;

@Service
@RequiredArgsConstructor
public class NScheduleService {

    private final NScheduleRepository nScheduleRepository;

    public CreateNScheduleResponseDto createSchedule(CreateNScheduleRequestDto createNScheduleRequestDto) {
        return this.nScheduleRepository.save(createNScheduleRequestDto);
    }
}