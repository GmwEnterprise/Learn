package cn.gmwenterprise.dubbo.service;

import cn.gmwenterprise.dubbo.domain.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> queryUsers();
}
