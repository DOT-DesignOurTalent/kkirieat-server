package io.dot.kkirieat.server.web;

import io.dot.kkirieat.server.application.UserService;
import io.dot.kkirieat.server.application.dto.LoginRequest;
import io.dot.kkirieat.server.application.dto.SignUpRequest;
import io.dot.kkirieat.server.application.dto.SignUpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    @ResponseStatus(value = HttpStatus.CREATED)
    public SignUpResponse signUp(@RequestBody final SignUpRequest request) {
        return userService.signUp(request);
    }

    @PostMapping("/login")
    @ResponseStatus(value = HttpStatus.OK)
    public void login(@RequestBody final LoginRequest request) {
        userService.login(request);
    }

}
