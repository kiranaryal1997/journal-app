package com.kiranaryal.journal_app.service;

import com.kiranaryal.journal_app.entity.Journal;
import com.kiranaryal.journal_app.entity.User;
import com.kiranaryal.journal_app.repository.JournalRepository;
import com.kiranaryal.journal_app.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(ObjectId myId) {
        return userRepository.findById(myId);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public void deleteById(ObjectId myId) {
        userRepository.deleteById(myId);
    }
}
