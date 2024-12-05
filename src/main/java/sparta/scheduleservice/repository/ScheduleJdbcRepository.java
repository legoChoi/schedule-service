package sparta.scheduleservice.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import sparta.scheduleservice.repository.dto.request.CreateScheduleRequestDto;
import sparta.scheduleservice.repository.dto.response.CreateScheduleResponseDto;

import javax.sql.DataSource;

@Slf4j
@Repository
public class ScheduleJdbcRepository implements ScheduleRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ScheduleJdbcRepository(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public CreateScheduleResponseDto save(CreateScheduleRequestDto createScheduleRequestDto) {
        String sql = "INSERT INTO schedules(user_id, schedule_password, title, contents) " +
                "VALUES (:userId, :schedulePassword, :title, :contents)";

        SqlParameterSource param = new BeanPropertySqlParameterSource(createScheduleRequestDto);
        KeyHolder key = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, param, key);

        return new CreateScheduleResponseDto(
                key.getKey().intValue(),
                createScheduleRequestDto.getUserId(),
                createScheduleRequestDto.getSchedulePassword(),
                createScheduleRequestDto.getTitle(),
                createScheduleRequestDto.getContents()
        );
    }
}
