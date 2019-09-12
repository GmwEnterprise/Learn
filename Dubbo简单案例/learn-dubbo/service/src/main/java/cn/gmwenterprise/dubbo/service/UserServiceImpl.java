package cn.gmwenterprise.dubbo.service;

import cn.gmwenterprise.dubbo.annotation.ProviderService;
import cn.gmwenterprise.dubbo.domain.User;
import cn.gmwenterprise.dubbo.repository.UserRepository;

import java.util.List;

@ProviderService
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.add(user);
    }

    @Override
    public List<User> queryUsers() {
        return userRepository.queryAll();
    }
}
