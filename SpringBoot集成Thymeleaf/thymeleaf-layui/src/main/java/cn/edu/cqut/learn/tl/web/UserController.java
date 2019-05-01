package cn.edu.cqut.learn.tl.web;

import cn.edu.cqut.learn.tl.domain.User;
import cn.edu.cqut.learn.tl.repository.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  private List<User> getUserList() {
    return userRepository.listUsers();
  }

  @GetMapping
  public ModelAndView list(Model model) {
    model.addAttribute("userList", getUserList());
    model.addAttribute("title", "用户管理");
    return new ModelAndView("users/list", "userModel", model);
  }

  @GetMapping("/{id}")
  public ModelAndView view(@PathVariable("id") Long id, Model model) {
    User user = userRepository.getUserById(id);
    model.addAttribute("user", user);
    model.addAttribute("title", "查看用户");
    return new ModelAndView("users/view", "userModel", model);
  }

  @GetMapping("/form")
  public ModelAndView createForm(Model model) {
    model.addAttribute("user", new User());
    model.addAttribute("title", "创建用户");
    return new ModelAndView("users/form", "userModel", model);
  }

  @PostMapping
  public ModelAndView create(User user) {
    user = userRepository.saveOrUpdateUser(user);
    return new ModelAndView("redirect:/users");
  }

  @GetMapping("/delete/{id}")
  public ModelAndView delete(@PathVariable("id") Long id, Model model) {
    userRepository.deleteUser(id);
    model.addAttribute("userList", getUserList());
    model.addAttribute("title", "删除用户");
    return new ModelAndView("users/list", "userModel", model);
  }

  @GetMapping("/modify/{id}")
  public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
    User user = userRepository.getUserById(id);
    model.addAttribute("user", user);
    model.addAttribute("title", "修改用户");
    return new ModelAndView("users/form", "userModel", model);
  }
}
