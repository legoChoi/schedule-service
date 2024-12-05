package sparta.scheduleservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sparta.scheduleservice.repository.ScheduleRepository;
import sparta.scheduleservice.repository.dto.schedule.request.CreateScheduleRequestDto;
import sparta.scheduleservice.repository.dto.schedule.request.FetchScheduleListConditionDto;
import sparta.scheduleservice.repository.dto.schedule.request.UpdateScheduleRequestDto;
import sparta.scheduleservice.repository.dto.schedule.response.CreateScheduleResponseDto;
import sparta.scheduleservice.repository.dto.schedule.response.FetchScheduleResponseDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public CreateScheduleResponseDto createSchedule(CreateScheduleRequestDto createScheduleRequestDto) {
        return this.scheduleRepository.save(createScheduleRequestDto);
    }

    public FetchScheduleResponseDto fetchOne(int scheduleId) {
        return this.scheduleRepository.fetchOne(scheduleId);
    }

    public List<FetchScheduleResponseDto> fetchAll(FetchScheduleListConditionDto fetchScheduleListConditionDto) {
        return this.scheduleRepository.fetchAll(fetchScheduleListConditionDto);
    }

    public int updateSchedule(int scheduleId, UpdateScheduleRequestDto updateScheduleRequestDto) {
        return this.scheduleRepository.update(scheduleId, updateScheduleRequestDto);
    }
}
