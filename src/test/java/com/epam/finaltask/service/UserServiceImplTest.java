package com.epam.finaltask.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import com.epam.finaltask.dto.request.*;
import com.epam.finaltask.dto.response.UserDto;
import com.epam.finaltask.dto.response.UserSignInResponseDto;
import com.epam.finaltask.jwt.JwtService;
import com.epam.finaltask.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.epam.finaltask.mapper.UserMapper;
import com.epam.finaltask.model.User;
import com.epam.finaltask.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private PasswordEncoder passwordEncoder;

  @Mock
  private UserMapper userMapper;

    @Mock
    private JwtService jwtService;

  @InjectMocks
  private UserServiceImpl userService;

  @Test
  @DisplayName("findUserByEmail: Should find user by email When the user with this email exists")
  void getUserByEmail_UserExists_Success() {
    // Given
    String email = "existingUser@example.com";
    User user = new User();
    user.setEmail(email);

    UserDto expectedUserDto = new UserDto();
    expectedUserDto.setEmail(email);

    when(userRepository.findUserByEmail(email)).thenReturn(Optional.of(user));
    when(userMapper.toUserDTO(any(User.class))).thenReturn(expectedUserDto);

    // When
    UserDto result = userService.getUserByEmail(email);

    // Then
    assertNotNull(result, "The returned UserDTO should not be null");
    assertEquals(expectedUserDto.getEmail(), result.getEmail(),
        "The username should match the expected value");

    verify(userRepository, times(1)).findUserByEmail(email);
    verify(userMapper, times(1)).toUserDTO(any(User.class));
  }

  @Test
  @DisplayName("changeAccountStatus: Should change user account status When user exists")
  void changeAccountStatus_UserExist_Success() {
    // Given
    String userId = UUID.randomUUID().toString();
      UserChangeStatusRequestDto userChangeStatusRequestDto = new UserChangeStatusRequestDto();
      userChangeStatusRequestDto.setActive(true);

      UserDto userDTO = new UserDto();
      userDTO.setId(userId);
      userDTO.setActive(true);


    User user = new User();
    user.setId(UUID.fromString(userId));
    user.setActive(false);

    User updatedUser = new User();
    updatedUser.setId(UUID.fromString(userId));
    updatedUser.setActive(true);

    when(userRepository.findById(UUID.fromString(userId))).thenReturn(Optional.of(user));
//    when(userMapper.toUser(any(UserDTO.class))).thenReturn(updatedUser);
    when(userRepository.save(any(User.class))).thenReturn(updatedUser);
    when(userMapper.toUserDTO(any(User.class))).thenReturn(userDTO);

    // When
    UserDto resultDTO = userService.changeAccountStatus(userId, userChangeStatusRequestDto);

    // Then
    assertNotNull(resultDTO, "The returned UserDTO should not be null");
    assertTrue(resultDTO.isActive(), "The account status should be updated to true");

    verify(userRepository, times(1)).findById(UUID.fromString(userId));
    verify(userRepository, times(1)).save(any(User.class));
  }


  @Test
  @DisplayName("getUserById: Should find user by ID When the user with this ID exists")
  void getUserById_UserExist_Success() {
    // Given
    UUID id = UUID.randomUUID();
    User user = new User();
    user.setId(id);

    UserDto expectedUserDto = new UserDto();
    expectedUserDto.setId(id.toString());

    when(userRepository.findById(id)).thenReturn(Optional.of(user));
    when(userMapper.toUserDTO(any(User.class))).thenReturn(expectedUserDto);

    // When
    UserDto resultDTO = userService.getUserById(id.toString());

    // Then
    assertNotNull(resultDTO, "The returned UserDTO should not be null");
    assertEquals(expectedUserDto.getId(), resultDTO.getId(),
        "The user ID should match the expected value");

    verify(userRepository, times(1)).findById(id);
    verify(userMapper, times(1)).toUserDTO(any(User.class));
  }

    @Test
    @DisplayName("register: Should create user successfully")
    void register_ShouldCreateUser_Success() {
        // Given
        UserSignUpRequestDto request = new UserSignUpRequestDto();
        request.setEmail("test@mail.com");
        request.setPassword("rawPassword");

        User user = new User();
        user.setEmail(request.getEmail());

        User savedUser = new User();
        savedUser.setEmail(request.getEmail());

        UserDto expected = new UserDto();
        expected.setEmail(request.getEmail());

        when(passwordEncoder.encode(request.getPassword())).thenReturn("encodedPassword");
//        when(userMapper.toUserSignUp(any(UserSignUpRequestDto.class))).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        when(userMapper.toUserDTO(savedUser)).thenReturn(expected);

        // When
        UserDto result = userService.register(request);

        // Then
        assertNotNull(result);
        assertEquals(request.getEmail(), result.getEmail());

        verify(userRepository).save(any(User.class));
        verify(passwordEncoder).encode(request.getPassword());
    }

    @Test
    @DisplayName("authorize: Should return token when credentials are valid")
    void authorize_ShouldReturnToken_Success() {
        // Given
        UserSignInRequestDto request = new UserSignInRequestDto();
        request.setEmail("test@mail.com");
        request.setPassword("password");

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword("encoded");

        UserSignInResponseDto response = new UserSignInResponseDto();
        response.setToken("jwt-token");

        when(userRepository.findUserByEmail(request.getEmail()))
                .thenReturn(Optional.of(user));

        when(passwordEncoder.matches(request.getPassword(), user.getPassword()))
                .thenReturn(true);

        // предположим, что у тебя есть jwtService
        when(jwtService.generateToken(user)).thenReturn("jwt-token");

        // When
        UserSignInResponseDto result = userService.authorize(request);

        // Then
        assertNotNull(result);
        assertEquals("jwt-token", result.getToken());
    }

    @Test
    @DisplayName("updateUser: Should update user when exists")
    void updateUser_ShouldUpdateUser_Success() {
        // Given
        String userId = UUID.randomUUID().toString();

        User existing = new User();
        existing.setId(UUID.fromString(userId));

        UserDto dto = new UserDto();
        dto.setEmail("new@mail.com");

        User updated = new User();
        updated.setId(UUID.fromString(userId));
        updated.setEmail(dto.getEmail());

        UserDto expected = new UserDto();
        expected.setEmail(dto.getEmail());

        when(userRepository.findById(UUID.fromString(userId)))
                .thenReturn(Optional.of(existing));

        when(userRepository.save(any(User.class)))
                .thenReturn(updated);

        when(userMapper.toUser(any(UserDto.class)))
                .thenReturn(updated);

        when(userMapper.toUserDTO(updated))
                .thenReturn(expected);

        // When
        UserDto result = userService.updateUser(userId, dto);

        // Then
        assertNotNull(result);
        assertEquals(dto.getEmail(), result.getEmail());
    }

    @Test
    @DisplayName("getUserById: Should throw exception when user not found")
    void getUserById_ShouldThrowException_WhenUserNotFound() {
        // Given
        UUID id = UUID.randomUUID();

        when(userRepository.findById(id)).thenReturn(Optional.empty());

        // When + Then
        assertThrows(RuntimeException.class, () -> userService.getUserById(id.toString()));
    }

    @Test
    @DisplayName("getUserByEmail: Should throw exception when user not found")
    void getUserByEmail_ShouldThrow_WhenNotFound() {
        when(userRepository.findUserByEmail("x")).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class,
                () -> userService.getUserByEmail("x"));
    }
}
