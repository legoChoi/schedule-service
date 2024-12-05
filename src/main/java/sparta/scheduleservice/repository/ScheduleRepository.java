package sparta.scheduleservice.repository;

import sparta.scheduleservice.repository.dto.schedule.request.CreateScheduleRequestDto;
import sparta.scheduleservice.repository.dto.schedule.request.DeleteScheduleRequestDto;
import sparta.scheduleservice.repository.dto.schedule.request.FetchScheduleListConditionDto;
import sparta.scheduleservice.repository.dto.schedule.request.UpdateScheduleRequestDto;
import sparta.scheduleservice.repository.dto.schedule.response.CreateScheduleResponseDto;
import sparta.scheduleservice.repository.dto.schedule.response.FetchScheduleResponseDto;

import java.util.List;

public interface ScheduleRepository {
    CreateScheduleResponseDto save(CreateScheduleRequestDto createScheduleRequestDto);
    FetchScheduleResponseDto fetchOne(int scheduleId);
    List<FetchScheduleResponseDto> fetchAll(FetchScheduleListConditionDto fetchScheduleListConditionDto);
    int update(int scheduleId, UpdateScheduleRequestDto updateScheduleRequestDto);
    int delete(int scheduleId, DeleteScheduleRequestDto deleteScheduleRequestDto);
}
