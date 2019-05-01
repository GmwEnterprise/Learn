package com.example.learn.thymeleaf.web;

import com.example.learn.thymeleaf.domain.User;
import com.example.learn.thymeleaf.enums.Sex;
import com.example.learn.thymeleaf.repository.UserRepository;
import com.example.learn.thymeleaf.vo.AjaxResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/user", method = { RequestMethod.GET, RequestMethod.POST })
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
    initData();
  }

  private void initData() {
    for (int i = 1; i <= 5; i++) {
      User user = new User();
      user.setName("测试用户-" + i);
      user.setSex(i % 2 == 0 ? Sex.MAN : Sex.WOMAN);
      userRepository.saveOrUpdateUser(user);
    }
  }

  @GetMapping("/")
  public ModelAndView userList(ModelAndView mv) {
    List<User> userList = userRepository.getUserList();
    mv.addObject("userList", userList.size() == 0 ? null : userList);
    mv.setViewName("user/list");
    return mv;
  }

  @GetMapping("/{id}")
  public ModelAndView userDetail(@PathVariable("id") Long id, ModelAndView mv) {
    mv.addObject("user", userRepository.getUserById(id));
    mv.setViewName("user/update");
    return mv;
  }

  @PostMapping("/save")
  public ModelAndView saveOrUpdateUser(User user) {
    user = userRepository.saveOrUpdateUser(user);
    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:/user");
    return mv;
  }

  @ResponseBody
  @GetMapping("/delete/{id}")
  public AjaxResponse deleteUserById(@PathVariable("id") Long id) {
    userRepository.deleteUserById(id);
    return AjaxResponse.success(null);
  }
}
