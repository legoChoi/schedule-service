package sparta.scheduleservice.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import sparta.scheduleservice.repository.dto.request.CreateScheduleRequestDto;
import sparta.scheduleservice.repository.dto.request.FetchScheduleListConditionDto;
import sparta.scheduleservice.repository.dto.request.UpdateScheduleRequestDto;
import sparta.scheduleservice.repository.dto.response.CreateScheduleResponseDto;
import sparta.scheduleservice.repository.dto.response.FetchScheduleResponseDto;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Repository
public class ScheduleJdbcRepository implements ScheduleRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ScheduleJdbcRepository(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public CreateScheduleResponseDto save(CreateScheduleRequestDto createScheduleRequestDto) {
        String sql = "INSERT INTO " +
                "schedules(user_id, schedule_password, writer, contents) " +
                "VALUES (:userId, :schedulePassword, :writer, :contents)";

        SqlParameterSource param = new BeanPropertySqlParameterSource(createScheduleRequestDto);
        KeyHolder key = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, param, key);

        return new CreateScheduleResponseDto(
                key.getKey().intValue(),
                createScheduleRequestDto.getUserId(),
                createScheduleRequestDto.getSchedulePassword(),
                createScheduleRequestDto.getWriter(),
                createScheduleRequestDto.getContents()
        );
    }

    @Override
    public int update(int scheduleId, UpdateScheduleRequestDto updateScheduleRequestDto) {
        String sql = "UPDATE schedules " +
                "SET writer = :writer, contents = :contents " +
                "WHERE schedule_id = :scheduleId AND schedule_password LIKE :schedulePassword";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("writer", updateScheduleRequestDto.getWriter())
                .addValue("contents", updateScheduleRequestDto.getContents())
                .addValue("scheduleId", scheduleId)
                .addValue("schedulePassword", updateScheduleRequestDto.getSchedulePassword());

        return jdbcTemplate.update(sql, param);
    }

    @Override
    public FetchScheduleResponseDto fetchOne(int scheduleId) {
        String sql = "SELECT " +
                "schedule_id, " +
                "writer, " +
                "contents, " +
                "created_at, " +
                "updated_at " +
                "FROM schedules " +
                "WHERE schedule_id = :scheduleId";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("scheduleId", scheduleId);

        RowMapper<FetchScheduleResponseDto> rowMapper = BeanPropertyRowMapper
                .newInstance(FetchScheduleResponseDto.class);

        // 예외 처리 필수

        return jdbcTemplate.queryForObject(sql, param, rowMapper);
    }

    @Override
    public List<FetchScheduleResponseDto> fetchAll(FetchScheduleListConditionDto fetchScheduleListConditionDto) {
        String writer = fetchScheduleListConditionDto.getWriter();
        String updatedAt = fetchScheduleListConditionDto.getUpdatedAt();

        SqlParameterSource param = new BeanPropertySqlParameterSource(fetchScheduleListConditionDto);

        // 동적 쿼리
        String whereSql = "";
        Boolean flag = false;

        // 둘 중 하나라도 있으면 where 절 추가
        if (StringUtils.hasText(writer) || StringUtils.hasText(updatedAt)) {
            whereSql += "WHERE ";
        }


        // writer 있으면 조건에 추가
        if (StringUtils.hasText(writer)) {
            whereSql += "writer LIKE CONCAT('%', :writer, '%') ";
            flag = true;
        }

        // updatedAt 있으면 조건에 추가
        if (StringUtils.hasText(updatedAt)) {
            if (flag) {
                whereSql += "AND ";
            }
            whereSql += "DATE(updated_at) = :updatedAt ";
        }

        String sql = "SELECT " +
                "schedule_id, " +
                "writer, " +
                "contents, " +
                "created_at, " +
                "updated_at " +
                "FROM schedules " +
                whereSql +
                "ORDER BY updated_at DESC";

        RowMapper<FetchScheduleResponseDto> rowMapper = BeanPropertyRowMapper
                .newInstance(FetchScheduleResponseDto.class);

        return jdbcTemplate.query(sql, param, rowMapper);
    }
}
