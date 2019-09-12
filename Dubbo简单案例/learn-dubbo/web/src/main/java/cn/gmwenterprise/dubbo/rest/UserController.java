package cn.gmwenterprise.dubbo.rest;

import cn.gmwenterprise.dubbo.domain.User;
import cn.gmwenterprise.dubbo.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @GetMapping("/all")
    public List<User> queryAll() {
        return userService.queryUsers();
    }

    @PostMapping("/add")
    public User add(User user) {
        userService.addUser(user);
        return user;
    }
}
