package cn.edu.cqut.myapp.web;

import cn.edu.cqut.myapp.domain.AppUser;
import cn.edu.cqut.myapp.dto.LoginDto;
import cn.edu.cqut.myapp.dto.RegisterDto;
import cn.edu.cqut.myapp.service.AppUserService;
import cn.edu.cqut.myapp.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class AppUserController implements BaseController {

  private final AppUserService appUserService;

  public AppUserController(AppUserService appUserService) {
    this.appUserService = appUserService;
  }

  @PostMapping("/reg")
  public AjaxResponse register(RegisterDto data) {
    AppUser user = new AppUser();
    user.setUsername(data.getUsername());
    user.setPassword(data.getPassword());
    user.setUserPhone(data.getPhone());
    System.out.println(user);
    // TODO 参数校验
    return success();
  }

  @PostMapping("/login")
  public AjaxResponse login(LoginDto data) {
    AppUser user = new AppUser();
    user.setUserPhone(data.getPhone());
    user.setPassword(data.getPassword());
    System.out.println(user);

    return success();
  }
}
