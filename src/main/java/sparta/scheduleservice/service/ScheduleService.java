package sparta.scheduleservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.scheduleservice.dto.schedule.request.*;
import sparta.scheduleservice.repository.schedule.ScheduleRepository;
import sparta.scheduleservice.dto.schedule.response.CreateScheduleResponseDto;
import sparta.scheduleservice.dto.schedule.response.FetchScheduleResponseDto;
import sparta.scheduleservice.exception.schedule.exception.exceptions.PasswordMismatchException;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ResponseEntity<CreateScheduleResponseDto> createSchedule(CreateScheduleRequestDto createScheduleRequestDto) {
        return this.scheduleRepository.save(createScheduleRequestDto);
    }

    public ResponseEntity<FetchScheduleResponseDto> fetchOne(int scheduleId) {
        return this.scheduleRepository.fetchOne(scheduleId);
    }

    public ResponseEntity<List<FetchScheduleResponseDto>> fetchAll(FetchScheduleListConditionDto fetchScheduleListConditionDto) {
        return this.scheduleRepository.fetchAll(fetchScheduleListConditionDto);
    }

    /**
     * 1. 일정 비밀번호 select
     * 2. 검증 후 update
     * @param scheduleId
     * @param updateScheduleRequestDto
     * @return
     */
    @Transactional
    public int updateSchedule(int scheduleId, UpdateScheduleRequestDto updateScheduleRequestDto) {
        String schedulePassword = this.scheduleRepository.getSchedulePw(scheduleId);

        if (schedulePassword.equals(updateScheduleRequestDto.getSchedulePassword())) {
            return this.scheduleRepository.update(scheduleId, updateScheduleRequestDto);
        }

        throw new PasswordMismatchException();
    }

    /**
     * 1. 일정 비밀번호 select
     * 2. 검증 후 delete
     * @param scheduleId
     * @param deleteScheduleRequestDto
     * @return
     */
    @Transactional
    public int deleteSchedule(int scheduleId, DeleteScheduleRequestDto deleteScheduleRequestDto) {
        String schedulePassword = this.scheduleRepository.getSchedulePw(scheduleId);

        if (schedulePassword.equals(deleteScheduleRequestDto.getSchedulePassword())) {
            return this.scheduleRepository.delete(scheduleId, deleteScheduleRequestDto);
        }

        throw new PasswordMismatchException();
    }

    public ResponseEntity<List<FetchScheduleResponseDto>> paginateSchedule(PaginateRequestDto paginateRequestDto) {
        return this.scheduleRepository.paginate(paginateRequestDto);
    }
}
