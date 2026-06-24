package com.epam.finaltask.service;

import java.util.UUID;

import com.epam.finaltask.dto.request.*;
import com.epam.finaltask.dto.response.UserDTO;
import com.epam.finaltask.dto.response.UserSignInResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDTO register(UserSignUpRequestDto userDTO);
    UserSignInResponseDto authorize(UserSignInRequestDto userSignInRequestDto);
    UserDTO updateUser(String userId, UserDTO userDTO);
    UserDTO getUserByEmail(String email);
    UserDTO changeAccountStatus(String userId, UserChangeStatusRequestDto userDTO);
    UserDTO getUserById(String id);
    PagedModel<UserDTO> getAll(UserSearchQueryParamsRequestDto queryParams, Pageable pageable);
    UserDetailsService getUserDetailsService();
}
