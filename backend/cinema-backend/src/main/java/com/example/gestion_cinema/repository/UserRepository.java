package com.example.gestion_cinema.repository;

import com.example.gestion_cinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.role = 'user'")
    List<User> findAllUsers();
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
}
