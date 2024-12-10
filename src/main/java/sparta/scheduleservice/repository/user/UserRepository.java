package sparta.scheduleservice.repository.user;

import sparta.scheduleservice.dto.user.request.CreateUserRequestDto;
import sparta.scheduleservice.dto.user.request.DeleteUserReqDto;
import sparta.scheduleservice.dto.user.response.CreateUserResponseDto;

public interface UserRepository {
    /**
     * 유저 생성
     * @param createUserDto
     * @return
     */
    CreateUserResponseDto save(CreateUserRequestDto createUserDto);

    /**
     * 유저 삭제
     */
    void delete(DeleteUserReqDto deleteUserReqDto);
}
