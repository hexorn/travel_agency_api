package com.epam.finaltask.restcontroller;

import com.epam.finaltask.dto.request.UserSignInRequestDto;
import com.epam.finaltask.dto.request.UserSignUpRequestDto;
import com.epam.finaltask.dto.response.UserDto;
import com.epam.finaltask.jwt.JwtService;
import com.epam.finaltask.service.UserService;
import com.epam.finaltask.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.epam.finaltask.dto.response.UserSignInResponseDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthenticationRestController {
    private final UserService userService;
    private final JwtService jwtService;
    public static final String BEARER_PREFIX = "Bearer ";
    public static final String HEADER_NAME = "Authorization";

    @PostMapping("/sign-in")
    public UserSignInResponseDto signIn(@Valid @RequestBody UserSignInRequestDto userSignInRequestDto) {
        return userService.authorize(userSignInRequestDto);
    }

    @GetMapping("/profile")
    @JsonView(Views.Public.class)
    public UserDto getProfileInformation(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String authHeader = request.getHeader(HEADER_NAME);
        String jwt = authHeader.substring(BEARER_PREFIX.length());
        String email = jwtService.extractUserEmail(jwt);

        return userService.getUserByEmail(email);
    }

    @PostMapping("/sign-up")
    public UserDto signUpUser(@RequestBody @Valid UserSignUpRequestDto userDto) {
        return userService.register(userDto);
    }
}

