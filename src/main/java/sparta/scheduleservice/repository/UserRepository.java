package sparta.scheduleservice.repository;

import sparta.scheduleservice.repository.dto.user.request.CreateUserRequestDto;
import sparta.scheduleservice.repository.dto.user.response.CreateUserResponseDto;

public interface UserRepository {
    CreateUserResponseDto save(CreateUserRequestDto createUserDto);
}
