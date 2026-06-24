package com.epam.finaltask.restcontroller;

import com.epam.finaltask.dto.request.UserChangeStatusRequestDto;
import com.epam.finaltask.dto.request.UserCreateRequestDto;
import com.epam.finaltask.dto.request.UserSearchQueryParamsRequestDto;
import com.epam.finaltask.dto.response.UserDTO;
import com.epam.finaltask.service.UserService;
import com.epam.finaltask.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserRestController {
    private final UserService userService;

	@GetMapping
//    @JsonView(Views.Public.class)
    public PagedModel<UserDTO> getUsers(UserSearchQueryParamsRequestDto queryParams, @PageableDefault Pageable pageable) {
//        var users =userService.getAll(pageable);
//        return users;
        return userService.getAll(queryParams, pageable);
    }

    @JsonView(Views.Internal.class)
    @PatchMapping("/{userId}/status")
    public UserDTO updateUserStatus(@PathVariable(name = "userId") String userId, @RequestBody @Valid UserChangeStatusRequestDto userDTO ) {
        return userService.changeAccountStatus(userId, userDTO);
    }

    @PutMapping("/{userId}")
    public UserDTO updateUser( @PathVariable(name = "userId") String userId, @RequestBody UserDTO userDTO) {
        return userService.updateUser(userId, userDTO);
    }

//    @PostMapping
//    public UserDTO createUser(@Valid @RequestBody UserCreateRequestDto dto) {
//        return userService.createUser(dto);
//    }

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable(name = "userId") String userId) {
        return userService.getUserById(userId);
    }
}
