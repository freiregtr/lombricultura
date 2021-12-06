package com.lombricultura.app.repository;

import com.lombricultura.app.modelos.entities.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Primary
public interface UserRepository extends JpaRepository<User, Integer> {

    // Query Methods
    @Query("select u from User u where u.username = ?1")
    Optional<User> searchUserByName(String username);

}
