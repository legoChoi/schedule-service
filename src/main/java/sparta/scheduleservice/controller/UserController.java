package sparta.scheduleservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sparta.scheduleservice.dto.user.request.CreateUserRequestDto;
import sparta.scheduleservice.dto.user.request.DeleteUserReqDto;
import sparta.scheduleservice.dto.user.response.CreateUserResponseDto;
import sparta.scheduleservice.service.UserService;

@Slf4j
@RestController
@RequestMapping("/apis/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public CreateUserResponseDto createUser(
            @Valid @RequestBody CreateUserRequestDto createUserDto
    ) {
        return this.userService.createUser(createUserDto);
    }

    @DeleteMapping
    public void deleteUser(
            @Valid @RequestBody DeleteUserReqDto deleteUserDto
    ) {
        this.userService.deleteUser(deleteUserDto);
    }
}
