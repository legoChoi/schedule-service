package sparta.scheduleservice.repository.nschedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import sparta.scheduleservice.dto.nschedule.request.CreateNScheduleRequestDto;
import sparta.scheduleservice.dto.nschedule.response.CreateNScheduleResponseDto;

import javax.sql.DataSource;

@Slf4j
@Repository
public class NScheduleJdbcRepository implements NScheduleRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public NScheduleJdbcRepository(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public CreateNScheduleResponseDto save(CreateNScheduleRequestDto createNScheduleRequestDto) {
        String sql = "INSERT INTO n_schedules (user_name, schedule_password, title, contents) " +
                "VALUES (:userName, :schedulePassword, :title, :contents)";

        SqlParameterSource param = new BeanPropertySqlParameterSource(createNScheduleRequestDto);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, param, keyHolder);

        return new CreateNScheduleResponseDto(
                keyHolder.getKey().intValue(),
                createNScheduleRequestDto.getUserName(),
                createNScheduleRequestDto.getSchedulePassword(),
                createNScheduleRequestDto.getTitle(),
                createNScheduleRequestDto.getContents()
        );
    }
}
