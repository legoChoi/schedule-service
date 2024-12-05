package sparta.scheduleservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sparta.scheduleservice.repository.dto.request.CreateUserRequestDto;
import sparta.scheduleservice.repository.dto.response.CreateUserResponseDto;
import sparta.scheduleservice.service.UserService;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public CreateUserResponseDto createUser(@RequestBody CreateUserRequestDto createUserDto) {
        return this.userService.createUser(createUserDto);
    }
}
