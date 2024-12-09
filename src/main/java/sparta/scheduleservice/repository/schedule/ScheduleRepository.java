package sparta.scheduleservice.repository.schedule;

import org.springframework.http.ResponseEntity;
import sparta.scheduleservice.dto.schedule.request.*;
import sparta.scheduleservice.dto.schedule.response.CreateScheduleResponseDto;
import sparta.scheduleservice.dto.schedule.response.FetchScheduleResponseDto;

import java.util.List;

public interface ScheduleRepository {
    CreateScheduleResponseDto save(CreateScheduleRequestDto createScheduleRequestDto);
    FetchScheduleResponseDto fetchOne(int scheduleId);
    ResponseEntity<List<FetchScheduleResponseDto>> fetchAll(FetchScheduleListConditionDto fetchScheduleListConditionDto);
    int update(int scheduleId, UpdateScheduleRequestDto updateScheduleRequestDto);
    int delete(int scheduleId, DeleteScheduleRequestDto deleteScheduleRequestDto);
    ResponseEntity<List<FetchScheduleResponseDto>> paginate(PaginateRequestDto paginateRequestDto);
    String getSchedulePw(int scheduleId);
}
