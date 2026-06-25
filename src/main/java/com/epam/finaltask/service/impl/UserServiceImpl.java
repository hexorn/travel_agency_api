package com.epam.finaltask.service.impl;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import com.epam.finaltask.dto.request.*;
import com.epam.finaltask.dto.response.UserDto;
import com.epam.finaltask.dto.response.UserSignInResponseDto;
import com.epam.finaltask.exception.InvalidCredentialsException;
import com.epam.finaltask.exception.UserEntityNotFoundException;
import com.epam.finaltask.jwt.JwtService;
import com.epam.finaltask.mapper.UserMapper;
import com.epam.finaltask.model.Role;
import com.epam.finaltask.model.User;
import com.epam.finaltask.repository.UserRepository;
import com.epam.finaltask.service.UserService;
import com.epam.finaltask.specification.UserSearchSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PagedModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserSignInResponseDto authorize(UserSignInRequestDto userSignInRequestDto) {
        Optional<User> userOptional = userRepository.findUserByEmail(userSignInRequestDto.getEmail());
        if(userOptional.isEmpty()) {
            throw new InvalidCredentialsException();
//            throw new UserEntityNotFoundException(String.format("User with email: %s not found", userSignInRequestDto.email()));
        }
//        authenticationManager.authenticate()
        User u = userOptional.get();
        if(!passwordEncoder.matches(userSignInRequestDto.getPassword(), u.getPassword())) {
            throw new InvalidCredentialsException();
        }
        UserSignInResponseDto responseDto = new UserSignInResponseDto();
        responseDto.setToken(jwtService.generateToken(u));
        return responseDto;
    }

	@Override
	public UserDto register(UserSignUpRequestDto userDTO) {
//		User user = userMapper.toUser(userDTO);
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setRole(Role.USER);
        user.setBalance(BigDecimal.valueOf(10000));
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        User savedUser = userRepository.save(user);

        return userMapper.toUserDTO(savedUser);
	}

    @Override
	public UserDto updateUser(String userId, UserDto userDTO) {
        User userToUpdate = userMapper.toUser(userDTO);
        Optional<User> optionalUser = userRepository.findById(UUID.fromString(userId));
        if(optionalUser.isEmpty()) {
            throw new UserEntityNotFoundException(String.format("User with id: %s not found", userId));
        }
        User existingUser = optionalUser.get();

        userToUpdate.setId(existingUser.getId());

        User updatedUser = userRepository.save(userToUpdate);

        return userMapper.toUserDTO(updatedUser);
	}

	@Override
	public UserDto getUserByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if(user.isEmpty()) {
            throw new UserEntityNotFoundException(String.format("User with email: %s not found", email));
        }

        return userMapper.toUserDTO(user.get());
	}

	@Override
	public UserDto changeAccountStatus(String userId, UserChangeStatusRequestDto userDTO) {
//        User user = userMapper.toUser(userDTO);
        Optional<User> optionalExistingUser = userRepository.findById(UUID.fromString(userId));
        if(optionalExistingUser.isEmpty()) {
            throw new UserEntityNotFoundException(String.format("User with id: %s not found", userId));

        }

        User existingUser = optionalExistingUser.get();
        existingUser.setActive(userDTO.getActive());

        User updatedUser = userRepository.save(existingUser);

		return userMapper.toUserDTO(updatedUser);
	}

	@Override
	public UserDto getUserById(String id) {
        Optional<User> optionalExistingUser = userRepository.findById(UUID.fromString(id));
        if(optionalExistingUser.isEmpty()) {
            throw new UserEntityNotFoundException(String.format("User with id: %s not found", id));
        }

        return userMapper.toUserDTO(optionalExistingUser.get());
	}

    @Override
    public PagedModel<UserDto> getAll(UserSearchQueryParamsRequestDto queryParams, Pageable pageable) {
        Specification<User> specification = Specification.where(UserSearchSpecifications.hasEmail(queryParams.getEmail()))
                .and(UserSearchSpecifications.hasActiveStatus(queryParams.getActive()));

        Page<User> users = userRepository.findAll(specification, pageable);
        return userMapper.toUserDtoPage(users);
    }

    @Override
    public UserDetailsService getUserDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                return userRepository.findUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
