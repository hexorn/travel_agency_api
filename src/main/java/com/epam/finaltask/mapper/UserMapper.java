package com.epam.finaltask.mapper;

import com.epam.finaltask.dto.request.UserSignUpRequestDto;
import com.epam.finaltask.dto.response.UserDTO;
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
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);
    User toUserSignUp(UserSignUpRequestDto userDto);
    List<User> toUserList(List<UserDTO> userDTO);
    List<UserDTO> toUserDTOList(List<User> user);
    default PagedModel<UserDTO> toUserDtoPage(Page<User> usersPage) {
        List<UserDTO> userDtoList = toUserDTOList(usersPage.getContent());
        return new PagedModel<>(new PageImpl<>(userDtoList, usersPage.getPageable(), usersPage.getTotalElements()));
    }
}
