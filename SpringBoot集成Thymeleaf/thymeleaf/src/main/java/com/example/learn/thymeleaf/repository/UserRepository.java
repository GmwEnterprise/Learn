package com.example.learn.thymeleaf.repository;

import com.example.learn.thymeleaf.domain.User;

import java.util.List;

public interface UserRepository {

  User getUserById(Long id);

  List<User> getUserList();

  User saveOrUpdateUser(User user);

  void deleteUserById(Long id);
}
