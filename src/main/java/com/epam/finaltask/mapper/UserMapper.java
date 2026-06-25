package com.epam.finaltask.mapper;

import com.epam.finaltask.dto.request.UserSignUpRequestDto;
import com.epam.finaltask.dto.response.UserDto;
import com.epam.finaltask.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.web.PagedModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "password", ignore = true)
    User toUser(UserDto userDTO);
    UserDto toUserDTO(User user);
    User toUserSignUp(UserSignUpRequestDto userDto);
    List<User> toUserList(List<UserDto> userDTO);
    List<UserDto> toUserDTOList(List<User> user);
    default PagedModel<UserDto> toUserDtoPage(Page<User> usersPage) {
        List<UserDto> userDtoList = toUserDTOList(usersPage.getContent());
        return new PagedModel<>(new PageImpl<>(userDtoList, usersPage.getPageable(), usersPage.getTotalElements()));
    }
}
