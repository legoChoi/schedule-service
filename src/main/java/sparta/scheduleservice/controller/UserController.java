package sparta.scheduleservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /**
     * 유저 생성 API
     */
    @PostMapping
    public ResponseEntity<CreateUserResponseDto> createUser(
            @Valid @RequestBody CreateUserRequestDto createUserDto
    ) {
        CreateUserResponseDto data = this.userService.createUser(createUserDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(data);
    }

    /**
     * 유저 삭제 API - 작성된 스케줄도 삭제
     */
    @DeleteMapping
    public void deleteUser(
            @Valid @RequestBody DeleteUserReqDto deleteUserDto
    ) {
        this.userService.deleteUser(deleteUserDto);
    }
}
