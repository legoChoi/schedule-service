package sparta.scheduleservice.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sparta.scheduleservice.dto.user.request.DeleteUserReqDto;
import sparta.scheduleservice.repository.user.UserRepository;
import sparta.scheduleservice.dto.user.request.CreateUserRequestDto;
import sparta.scheduleservice.dto.user.response.CreateUserResponseDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public CreateUserResponseDto createUser(CreateUserRequestDto createUserDto) {
        return this.userRepository.save(createUserDto);
    }

    @Override
    public void deleteUser(DeleteUserReqDto deleteUserReqDto) {
        this.userRepository.delete(deleteUserReqDto);
    }
}
