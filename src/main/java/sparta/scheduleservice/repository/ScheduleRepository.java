package sparta.scheduleservice.repository;

import sparta.scheduleservice.repository.dto.request.CreateScheduleRequestDto;
import sparta.scheduleservice.repository.dto.request.FetchScheduleListConditionDto;
import sparta.scheduleservice.repository.dto.request.UpdateScheduleRequestDto;
import sparta.scheduleservice.repository.dto.response.CreateScheduleResponseDto;
import sparta.scheduleservice.repository.dto.response.FetchScheduleResponseDto;

import java.util.List;

public interface ScheduleRepository {
    CreateScheduleResponseDto save(CreateScheduleRequestDto createScheduleRequestDto);
    FetchScheduleResponseDto fetchOne(int scheduleId);
    List<FetchScheduleResponseDto> fetchAll(FetchScheduleListConditionDto fetchScheduleListConditionDto);
    int update(int scheduleId, UpdateScheduleRequestDto updateScheduleRequestDto);
}
