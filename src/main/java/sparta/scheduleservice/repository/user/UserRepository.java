package sparta.scheduleservice.repository.user;

import sparta.scheduleservice.dto.user.request.CreateUserRequestDto;
import sparta.scheduleservice.dto.user.request.DeleteUserReqDto;
import sparta.scheduleservice.dto.user.response.CreateUserResponseDto;

public interface UserRepository {
    CreateUserResponseDto save(CreateUserRequestDto createUserDto);
    void delete(DeleteUserReqDto deleteUserReqDto);
}
