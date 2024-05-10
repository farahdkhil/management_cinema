package com.example.gestion_cinema.service;

import com.example.gestion_cinema.Dtos.*;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto user);
    AuthenticationResponse authenticate(AuthenticationRequest user);
    List<UserDto> findAllUsers();
    void deleteUser(Long id);
    UserDataDto findById(Long id);
    void changePassword(ChangePassword passwordChange);

    AuthenticationResponse updateUserDetails(UserDataDto userDataDto);
}
