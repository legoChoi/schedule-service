package sparta.scheduleservice.service.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public CreateScheduleResponseDto createSchedule(CreateScheduleRequestDto createScheduleRequestDto) {
        return this.scheduleRepository.save(createScheduleRequestDto);
    }

    @Override
    public FetchScheduleResponseDto fetchOne(int scheduleId) {
        return this.scheduleRepository.fetchOne(scheduleId);
    }

    @Override
    public List<FetchScheduleResponseDto> fetchAll(FetchScheduleListConditionDto fetchScheduleListConditionDto) {
        return this.scheduleRepository.fetchAll(fetchScheduleListConditionDto);
    }

    @Override
    @Transactional
    public int updateSchedule(int scheduleId, UpdateScheduleRequestDto updateScheduleRequestDto) {
        String schedulePassword = this.scheduleRepository.getSchedulePw(scheduleId);

        if (schedulePassword.equals(updateScheduleRequestDto.getSchedulePassword())) {
            return this.scheduleRepository.update(scheduleId, updateScheduleRequestDto);
        }

        throw new PasswordMismatchException();
    }

    @Override
    @Transactional
    public int deleteSchedule(int scheduleId, DeleteScheduleRequestDto deleteScheduleRequestDto) {
        String schedulePassword = this.scheduleRepository.getSchedulePw(scheduleId);

        if (schedulePassword.equals(deleteScheduleRequestDto.getSchedulePassword())) {
            return this.scheduleRepository.delete(scheduleId, deleteScheduleRequestDto);
        }

        throw new PasswordMismatchException();
    }

    @Override
    public List<FetchScheduleResponseDto> paginateSchedule(PaginateRequestDto paginateRequestDto) {
        return this.scheduleRepository.paginate(paginateRequestDto);
    }
}
