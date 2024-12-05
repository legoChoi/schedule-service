package sparta.scheduleservice.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import sparta.scheduleservice.repository.dto.request.CreateUserRequestDto;
import sparta.scheduleservice.repository.dto.response.CreateUserResponseDto;

import javax.sql.DataSource;

@Slf4j
@Repository
public class UserJdbcRepository implements UserRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    public UserJdbcRepository(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("USERS")
                .usingGeneratedKeyColumns("user_id");
    }

    @Override
    public CreateUserResponseDto save(CreateUserRequestDto createUserDto) {
        String sql = "INSERT INTO USERS(user_name, user_email) " +
                "VALUES (:userName, :userEmail)";

        SqlParameterSource param = new BeanPropertySqlParameterSource(createUserDto);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, param, keyHolder);

        int userId = keyHolder.getKey().intValue();

        return new CreateUserResponseDto(
                userId,
                createUserDto.getUserName(),
                createUserDto.getUserEmail()
        );
    }
}
