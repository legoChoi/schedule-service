package sparta.scheduleservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sparta.scheduleservice.repository.UserRepository;
import sparta.scheduleservice.repository.dto.request.CreateUserRequestDto;
import sparta.scheduleservice.repository.dto.response.CreateUserResponseDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public CreateUserResponseDto createUser(CreateUserRequestDto createUserDto) {
        return this.userRepository.save(createUserDto);
    }
}
