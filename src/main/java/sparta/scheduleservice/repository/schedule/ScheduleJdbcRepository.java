package sparta.scheduleservice.repository.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import sparta.scheduleservice.dto.schedule.request.*;
import sparta.scheduleservice.dto.schedule.response.*;
import sparta.scheduleservice.exception.schedule.exception.exceptions.ScheduleNotFoundException;

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

        CreateScheduleResponseDto createScheduleResponseDto = new CreateScheduleResponseDto(
                key.getKey().intValue(),
                createScheduleRequestDto.getUserId(),
                createScheduleRequestDto.getSchedulePassword(),
                createScheduleRequestDto.getWriter(),
                createScheduleRequestDto.getContents()
        );

        return createScheduleResponseDto;
    }

    @Override
    public int update(int scheduleId, UpdateScheduleRequestDto updateScheduleRequestDto) {
        String sql = "UPDATE schedules " +
                "SET writer = :writer, contents = :contents " +
                "WHERE schedule_id = :scheduleId";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("writer", updateScheduleRequestDto.getWriter())
                .addValue("contents", updateScheduleRequestDto.getContents())
                .addValue("scheduleId", scheduleId);

        return jdbcTemplate.update(sql, param);
    }

    @Override
    public int delete(int scheduleId, DeleteScheduleRequestDto deleteScheduleRequestDto) {
        String sql = "DELETE FROM schedules WHERE schedule_id = :scheduleId AND schedule_password LIKE :schedulePassword";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("scheduleId", scheduleId)
                .addValue("schedulePassword", deleteScheduleRequestDto.getSchedulePassword());

        return jdbcTemplate.update(sql, param);
    }

    @Override
    public FetchScheduleResponseDto fetchOne(int scheduleId) {
        String sql = "SELECT " +
                "s.schedule_id AS scheduleId, " +
                "s.user_id AS userId, " +
                "s.writer AS writer, " +
                "u.user_name AS userName, " +
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

        try {
            return jdbcTemplate.queryForObject(sql, param, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new ScheduleNotFoundException();
        }
    }

    @Override
    public List<FetchScheduleResponseDto> fetchAll(FetchScheduleListConditionDto fetchScheduleListConditionDto) {
        String writer = fetchScheduleListConditionDto.getWriter();
        String updatedAt = fetchScheduleListConditionDto.getUpdatedAt();
        Integer userId = fetchScheduleListConditionDto.getUserId();

        SqlParameterSource param = new BeanPropertySqlParameterSource(fetchScheduleListConditionDto);

        // 동적 쿼리
        String whereSql = "";
        boolean flag = false;

        // 셋 중 하나라도 있으면 where 절 추가
        if (userId != null || StringUtils.hasText(writer) || StringUtils.hasText(updatedAt)) {
            whereSql += "WHERE ";
        }

        // userId가 있으면 조건 추가
        if (userId != null) {
            whereSql += "u.user_id = :userId ";
            flag = true;
        }

        // writer 있으면 조건에 추가
        if (StringUtils.hasText(writer)) {
            if (flag) {
                whereSql += "AND ";
            }
            whereSql += "s.writer LIKE CONCAT('%', :writer, '%') ";
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
                "s.user_id AS userId, " +
                "s.writer AS writer, " +
                "u.user_name AS userName, " +
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

    @Override
    public List<FetchScheduleResponseDto> paginate(PaginateRequestDto paginateRequestDto) {
        String sql = "SELECT " +
                "s.schedule_id AS scheduleId, " +
                "s.user_id AS userId, " +
                "s.writer AS writer, " +
                "u.user_name AS userName, " +
                "s.contents AS contents, " +
                "s.created_at AS createdAt, " +
                "s.updated_at AS updatedAt " +
                "FROM schedules s " +
                "INNER JOIN users u ON s.user_id = u.user_id " +
                "ORDER BY s.updated_at DESC " +
                "LIMIT :page, :size";

        SqlParameterSource param = new BeanPropertySqlParameterSource(paginateRequestDto);

        RowMapper<FetchScheduleResponseDto> rowMapper = BeanPropertyRowMapper
                .newInstance(FetchScheduleResponseDto.class);

        return jdbcTemplate.query(sql, param, rowMapper);
    }

    @Override
    public String getSchedulePw(int scheduleId) {
        String sql = "SELECT schedule_password FROM schedules WHERE schedule_id = :scheduleId";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("scheduleId", scheduleId);

        try {
            return jdbcTemplate.queryForObject(sql, param, String.class);
        } catch (EmptyResultDataAccessException e) {
            throw new ScheduleNotFoundException();
        }
    }
}
