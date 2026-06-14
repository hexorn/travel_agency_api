package com.epam.finaltask.service;

import java.util.Optional;
import java.util.UUID;

import com.epam.finaltask.dto.UserDTO;
import com.epam.finaltask.mapper.UserMapper;
import com.epam.finaltask.model.User;
import com.epam.finaltask.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(final UserRepository userRepository, final UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


	@Override
	public UserDTO register(UserDTO userDTO) {
		User user = userMapper.toUser(userDTO);
        User savedUser = userRepository.save(user);

        return userMapper.toUserDTO(savedUser);
	}

	@Override
	public UserDTO updateUser(String username, UserDTO userDTO) {
        User userToUpdate = userMapper.toUser(userDTO);
        Optional<User> optionalUser = userRepository.findUserByUsername(username);
        if(optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        User existingUser = optionalUser.get();

        if(!existingUser.getId().equals(userToUpdate.getId())) {
            throw new IllegalArgumentException("Users do not match");
        }

        User updatedUser = userRepository.save(userToUpdate);

        return userMapper.toUserDTO(updatedUser);
	}

	@Override
	public UserDTO getUserByUsername(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);
        if(user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        return userMapper.toUserDTO(user.get());
	}

	@Override
	public UserDTO changeAccountStatus(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        Optional<User> optionalExistingUser = userRepository.findById(user.getId());
        if(optionalExistingUser.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        User existingUser = optionalExistingUser.get();
        existingUser.setActive(user.isActive());

        User updatedUser = userRepository.save(existingUser);

		return userMapper.toUserDTO(updatedUser);
	}

	@Override
	public UserDTO getUserById(UUID id) {
        Optional<User> optionalExistingUser = userRepository.findById(id);
        if(optionalExistingUser.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        return userMapper.toUserDTO(optionalExistingUser.get());
	}

}
