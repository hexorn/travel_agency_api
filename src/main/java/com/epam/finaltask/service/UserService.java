package com.epam.finaltask.service;

import com.epam.finaltask.dto.request.*;
import com.epam.finaltask.dto.response.UserDto;
import com.epam.finaltask.dto.response.UserSignInResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDto register(UserSignUpRequestDto userDTO);
    UserSignInResponseDto authorize(UserSignInRequestDto userSignInRequestDto);
    UserDto updateUser(String userId, UserDto userDTO);
    UserDto getUserByEmail(String email);
    UserDto changeAccountStatus(String userId, UserChangeStatusRequestDto userDTO);
    UserDto getUserById(String id);
    PagedModel<UserDto> getAll(UserSearchQueryParamsRequestDto queryParams, Pageable pageable);
    UserDetailsService getUserDetailsService();
}
