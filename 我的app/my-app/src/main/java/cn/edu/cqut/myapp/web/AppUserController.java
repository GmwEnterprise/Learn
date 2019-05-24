package cn.edu.cqut.myapp.web;

import cn.edu.cqut.myapp.common.ServiceReturnVal;
import cn.edu.cqut.myapp.domain.AppUser;
import cn.edu.cqut.myapp.dto.AppUserBasicDto;
import cn.edu.cqut.myapp.service.AppUserService;
import cn.edu.cqut.myapp.status.Login;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class AppUserController implements BaseController {

  final AppUserService appUserService;

  // TODO 阅读：SB红书restful相关章节
  // TODO 研究org.springframework.http.ResponseEntity<T>作为controller返回类的方案
  // TODO 编写rest风格的接口

  // TODO mybatis运行过程、插件
  // TODO pageHelper的配置与使用

  @PostMapping
  public void signUp(@RequestBody AppUserBasicDto userBasic) {
    // 创建user
    AppUser user = appUserService.createAppUser(userBasic);
    if (user != null) {
      // 创建成功
    } else {
      // 创建失败
    }
  }

  @GetMapping
  public void signIn(AppUserBasicDto userBasic) {
    ServiceReturnVal<Login, AppUser> val = appUserService.userLoginOnBrowser(userBasic);
    if (val.getStatus().equals(Login.LOGIN_SUCCESS)) {
      // 验证成功
    } else {
      // 验证失败
    }
  }


}
