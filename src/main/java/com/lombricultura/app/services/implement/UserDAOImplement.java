package com.lombricultura.app.services.implement;

import com.lombricultura.app.modelos.entities.User;
import com.lombricultura.app.repository.UserRepository;
import com.lombricultura.app.services.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDAOImplement extends GenericDAOImplement<User, UserRepository> implements UserDAO {

    @Autowired
    public UserDAOImplement(UserRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> searchUserByName(String username) {
        return repository.searchUserByName(username);
    }
}
