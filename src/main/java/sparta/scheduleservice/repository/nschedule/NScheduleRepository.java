package sparta.scheduleservice.repository.nschedule;

import sparta.scheduleservice.dto.nschedule.request.CreateNScheduleRequestDto;
import sparta.scheduleservice.dto.nschedule.response.CreateNScheduleResponseDto;

public interface NScheduleRepository {
    CreateNScheduleResponseDto save(CreateNScheduleRequestDto createNScheduleRequestDto);
}
