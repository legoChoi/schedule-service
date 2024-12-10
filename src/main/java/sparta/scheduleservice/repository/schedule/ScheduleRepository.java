package sparta.scheduleservice.repository.schedule;

import org.springframework.http.ResponseEntity;
import sparta.scheduleservice.dto.schedule.request.*;
import sparta.scheduleservice.dto.schedule.response.CreateScheduleResponseDto;
import sparta.scheduleservice.dto.schedule.response.FetchScheduleResponseDto;

import java.util.List;

public interface ScheduleRepository {

    /**
     * 일정 생성
     * @param createScheduleRequestDto
     * @return
     */
    CreateScheduleResponseDto save(CreateScheduleRequestDto createScheduleRequestDto);

    /**
     * 일정 단건 조회
     * @param scheduleId
     * @return
     */
    FetchScheduleResponseDto fetchOne(int scheduleId);

    /**
     * 전체 일정 조회
     * @param fetchScheduleListConditionDto
     * @return
     */
    List<FetchScheduleResponseDto> fetchAll(FetchScheduleListConditionDto fetchScheduleListConditionDto);

    /**
     * 일정 갱신
     */
    int update(int scheduleId, UpdateScheduleRequestDto updateScheduleRequestDto);

    /**
     * 일정 삭제
     */
    int delete(int scheduleId, DeleteScheduleRequestDto deleteScheduleRequestDto);

    /**
     * 페이지네이션
     */
    List<FetchScheduleResponseDto> paginate(PaginateRequestDto paginateRequestDto);

    /**
     * 비밀번호 검증을 위해 schedule 비밀번호를 조회
     */
    String getSchedulePw(int scheduleId);
}
