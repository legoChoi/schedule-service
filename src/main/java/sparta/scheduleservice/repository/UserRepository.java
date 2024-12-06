package sparta.scheduleservice.repository;

import sparta.scheduleservice.dto.user.request.CreateUserRequestDto;
import sparta.scheduleservice.dto.user.response.CreateUserResponseDto;

public interface UserRepository {
    CreateUserResponseDto save(CreateUserRequestDto createUserDto);
}
