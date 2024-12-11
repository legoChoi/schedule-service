package sparta.scheduleservice.service.nschedule;

import sparta.scheduleservice.dto.nschedule.request.CreateNScheduleRequestDto;
import sparta.scheduleservice.dto.nschedule.response.CreateNScheduleResponseDto;

public interface NScheduleService {

    CreateNScheduleResponseDto createSchedule(CreateNScheduleRequestDto createNScheduleRequestDto);
}
