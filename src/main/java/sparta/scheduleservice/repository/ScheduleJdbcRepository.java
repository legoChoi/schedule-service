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
        String sql = "UPDATE schedules s " +
                "INNER JOIN users u ON s.user_id = u.user_id " +
                "SET u.user_name = :userName, " +
                "s.contents = :contents " +
                "WHERE s.schedule_id = :scheduleId AND s.schedule_password LIKE :schedulePassword";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("userName", updateScheduleRequestDto.getUserName())
                .addValue("contents", updateScheduleRequestDto.getContents())
                .addValue("scheduleId", scheduleId)
                .addValue("schedulePassword", updateScheduleRequestDto.getSchedulePassword());

        return jdbcTemplate.update(sql, param);
    }

    @Override
    public FetchScheduleResponseDto fetchOne(int scheduleId) {
        String sql = "SELECT " +
                "s.schedule_id AS scheduleId, " +
                "u.user_name AS userName, " +
                "s.title AS title, " +
                "s.contents AS contents, " +
                "s.created_at AS createdAt, " +
                "s.updated_at AS updatedAt " +
                "FROM schedules s " +
                "INNER JOIN users u ON s.user_id = u.user_id " +
                "WHERE s.schedule_id = :scheduleId";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("scheduleId", scheduleId);

        RowMapper<FetchScheduleResponseDto> rowMapper = BeanPropertyRowMapper
                .newInstance(FetchScheduleResponseDto.class);

        // 예외 처리 필수

        return jdbcTemplate.queryForObject(sql, param, rowMapper);
    }

    @Override
    public List<FetchScheduleResponseDto> fetchAll(FetchScheduleListConditionDto fetchScheduleListConditionDto) {
        String userName = fetchScheduleListConditionDto.getUserName();
        String updatedAt = fetchScheduleListConditionDto.getUpdatedAt();

        SqlParameterSource param = new BeanPropertySqlParameterSource(fetchScheduleListConditionDto);

        // 동적 쿼리
        String whereSql = "";
        Boolean flag = false;

        // 둘 중 하나라도 있으면 where 절 추가
        if (StringUtils.hasText(userName) || StringUtils.hasText(updatedAt)) {
            whereSql += "WHERE ";
        }


        // userName 있으면 조건에 추가
        if (StringUtils.hasText(userName)) {
            whereSql += "u.user_name LIKE CONCAT('%', :userName, '%') ";
            flag = true;
        }

        // updatedAt 있으면 조건에 추가
        if (StringUtils.hasText(updatedAt)) {
            if (flag) {
                whereSql += "AND ";
            }
            whereSql += "DATE(s.updated_at) = :updatedAt ";
        }

        String sql = "SELECT " +
                "s.schedule_id AS scheduleId, " +
                "u.user_name AS userName, " +
                "s.title AS title, " +
                "s.contents AS contents, " +
                "s.created_at AS createdAt, " +
                "s.updated_at AS updatedAt " +
                "FROM schedules s " +
                "INNER JOIN users u ON s.user_id = u.user_id " +
                whereSql +
                "ORDER BY s.updated_at DESC";

        RowMapper<FetchScheduleResponseDto> rowMapper = BeanPropertyRowMapper
                .newInstance(FetchScheduleResponseDto.class);

        return jdbcTemplate.query(sql, param, rowMapper);
    }
}
