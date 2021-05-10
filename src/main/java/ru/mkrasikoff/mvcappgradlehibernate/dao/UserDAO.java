package ru.mkrasikoff.mvcappgradlehibernate.dao;

import ru.mkrasikoff.mvcappgradlehibernate.model.User;

public class UserDAO {
    private UserRepository userRepository;

    public User findUserById(int id) {
        return userRepository.findById(id).get();
    }
}
