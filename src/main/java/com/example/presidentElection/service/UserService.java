package com.example.presidentElection.service;

import com.example.presidentElection.dto.UserDto;
import com.example.presidentElection.entity.User;
import com.example.presidentElection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    User findUserById(Long id);

    List<UserDto> findAllUsers();
}
