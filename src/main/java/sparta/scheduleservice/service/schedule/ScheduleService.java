package sparta.scheduleservice.service.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.scheduleservice.dto.schedule.request.*;
import sparta.scheduleservice.repository.schedule.ScheduleRepository;
import sparta.scheduleservice.dto.schedule.response.CreateScheduleResponseDto;
import sparta.scheduleservice.dto.schedule.response.FetchScheduleResponseDto;
import sparta.scheduleservice.shared.exception.schedule.exception.PasswordMismatchException;

import java.util.List;

@Slf4j
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

    @Transactional
    public int updateSchedule(int scheduleId, UpdateScheduleRequestDto updateScheduleRequestDto) {
        // 비밀번호 검증
        String schedulePassword = this.scheduleRepository.getSchedulePw(scheduleId);

        // 성공
        if (schedulePassword.equals(updateScheduleRequestDto.getSchedulePassword())) {
            return this.scheduleRepository.update(scheduleId, updateScheduleRequestDto);
        }

        // 실패
        throw new PasswordMismatchException();
    }

    @Transactional
    public int deleteSchedule(int scheduleId, DeleteScheduleRequestDto deleteScheduleRequestDto) {
        // 비밀번호 검증
        String schedulePassword = this.scheduleRepository.getSchedulePw(scheduleId);

        // 성공
        if (schedulePassword.equals(deleteScheduleRequestDto.getSchedulePassword())) {
            return this.scheduleRepository.delete(scheduleId, deleteScheduleRequestDto);
        }

        // 실패
        throw new PasswordMismatchException();
    }

    public ResponseEntity<List<FetchScheduleResponseDto>> paginateSchedule(PaginateRequestDto paginateRequestDto) {
        return this.scheduleRepository.paginate(paginateRequestDto);
    }
}
