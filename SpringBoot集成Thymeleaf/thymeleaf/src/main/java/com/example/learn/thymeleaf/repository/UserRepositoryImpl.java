package com.example.learn.thymeleaf.repository;

import com.example.learn.thymeleaf.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private static AtomicLong counter = new AtomicLong();

  private ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();

  @Override
  public User getUserById(Long id) {
    return userMap.get(id);
  }

  @Override
  public List<User> getUserList() {
    return new ArrayList<>(userMap.values());
  }

  @Override
  public User saveOrUpdateUser(User user) {
    if (user.getId() == null) {
      user.setId(counter.incrementAndGet());
    }
    userMap.put(user.getId(), user);
    return user;
  }

  @Override
  public void deleteUserById(Long id) {
    userMap.remove(id);
  }
}
