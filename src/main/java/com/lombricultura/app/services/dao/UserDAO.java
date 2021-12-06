package com.lombricultura.app.services.dao;

import com.lombricultura.app.modelos.entities.User;

import java.util.Optional;

public interface UserDAO extends GenericDAO<User>{
    Optional<User> searchUserByName(String username);
}
