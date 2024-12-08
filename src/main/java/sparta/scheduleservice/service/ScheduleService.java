package sparta.scheduleservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sparta.scheduleservice.dto.schedule.request.*;
import sparta.scheduleservice.repository.ScheduleRepository;
import sparta.scheduleservice.dto.schedule.response.CreateScheduleResponseDto;
import sparta.scheduleservice.dto.schedule.response.FetchScheduleResponseDto;

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

    public ResponseEntity<List<FetchScheduleResponseDto>> fetchAll(FetchScheduleListConditionDto fetchScheduleListConditionDto) {
        return this.scheduleRepository.fetchAll(fetchScheduleListConditionDto);
    }

    public int updateSchedule(int scheduleId, UpdateScheduleRequestDto updateScheduleRequestDto) {
        return this.scheduleRepository.update(scheduleId, updateScheduleRequestDto);
    }

    public int deleteSchedule(int scheduleId, DeleteScheduleRequestDto deleteScheduleRequestDto) {
        return this.scheduleRepository.delete(scheduleId, deleteScheduleRequestDto);
    }

    public ResponseEntity<List<FetchScheduleResponseDto>> paginateSchedule(PaginateRequestDto paginateRequestDto) {
        return this.scheduleRepository.paginate(paginateRequestDto);
    }
}
