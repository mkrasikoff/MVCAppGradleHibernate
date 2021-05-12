package ru.mkrasikoff.mvcappgradlehibernate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mkrasikoff.mvcappgradlehibernate.model.User;

@Component
public class UserDAO {

    private final UserRepository userRepository;

    @Autowired
    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(int id) {
        return userRepository.findById(id).get();
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.delete(userRepository.findById(id).get());
    }
}
