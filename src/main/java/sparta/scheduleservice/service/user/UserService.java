package sparta.scheduleservice.service.user;

import sparta.scheduleservice.dto.user.request.CreateUserRequestDto;
import sparta.scheduleservice.dto.user.request.DeleteUserReqDto;
import sparta.scheduleservice.dto.user.response.CreateUserResponseDto;

public interface UserService {
    CreateUserResponseDto createUser(CreateUserRequestDto createUserDto);
    void deleteUser(DeleteUserReqDto deleteUserReqDto);
}
