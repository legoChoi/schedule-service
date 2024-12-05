package sparta.scheduleservice.repository;

import sparta.scheduleservice.repository.dto.request.CreateNScheduleRequestDto;
import sparta.scheduleservice.repository.dto.response.CreateNScheduleResponseDto;

public interface NScheduleRepository {
    CreateNScheduleResponseDto save(CreateNScheduleRequestDto createNScheduleRequestDto);
}
