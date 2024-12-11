package sparta.scheduleservice.service.schedule;

import sparta.scheduleservice.dto.schedule.request.*;
import sparta.scheduleservice.dto.schedule.response.CreateScheduleResponseDto;
import sparta.scheduleservice.dto.schedule.response.FetchScheduleResponseDto;

import java.util.List;

public interface ScheduleService {

    public CreateScheduleResponseDto createSchedule(CreateScheduleRequestDto createScheduleRequestDto);
    public FetchScheduleResponseDto fetchOne(int scheduleId);
    public List<FetchScheduleResponseDto> fetchAll(FetchScheduleListConditionDto fetchScheduleListConditionDto);
    /**
     * 1. 일정 비밀번호 select
     * 2. 검증 후 update
     * @param scheduleId
     * @param updateScheduleRequestDto
     * @return
     */
    public int updateSchedule(int scheduleId, UpdateScheduleRequestDto updateScheduleRequestDto);
    /**
     * 1. 일정 비밀번호 select
     * 2. 검증 후 delete
     * @param scheduleId
     * @param deleteScheduleRequestDto
     * @return
     */
    public int deleteSchedule(int scheduleId, DeleteScheduleRequestDto deleteScheduleRequestDto);
    public List<FetchScheduleResponseDto> paginateSchedule(PaginateRequestDto paginateRequestDto);
}
