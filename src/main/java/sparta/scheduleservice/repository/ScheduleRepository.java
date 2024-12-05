package sparta.scheduleservice.repository;

import sparta.scheduleservice.repository.dto.request.CreateScheduleRequestDto;
import sparta.scheduleservice.repository.dto.response.CreateScheduleResponseDto;

public interface ScheduleRepository {
    CreateScheduleResponseDto save(CreateScheduleRequestDto createScheduleRequestDto);
}
