package cn.edu.cqut.learn.tl.repository;

import cn.edu.cqut.learn.tl.domain.User;

import java.util.List;

public interface UserRepository {

  User saveOrUpdateUser(User user);

  void deleteUser(Long id);

  User getUserById(Long id);

  List<User> listUsers();
}
