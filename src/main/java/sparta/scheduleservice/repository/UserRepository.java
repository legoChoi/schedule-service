package sparta.scheduleservice.repository;

import sparta.scheduleservice.repository.dto.request.CreateUserRequestDto;
import sparta.scheduleservice.repository.dto.response.CreateUserResponseDto;

public interface UserRepository {
    CreateUserResponseDto save(CreateUserRequestDto createUserDto);
}
