package ru.mkrasikoff.mvcappgradlehibernate.dao;

import org.springframework.data.repository.CrudRepository;
import ru.mkrasikoff.mvcappgradlehibernate.model.User;


public interface UserRepository extends CrudRepository<User, Integer> {
}
