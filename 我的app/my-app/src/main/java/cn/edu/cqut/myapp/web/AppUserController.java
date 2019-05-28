package cn.edu.cqut.myapp.web;

import cn.edu.cqut.myapp.common.AuthToken;
import cn.edu.cqut.myapp.common.Re;
import cn.edu.cqut.myapp.common.ServiceReturnVal;
import cn.edu.cqut.myapp.domain.AppUser;
import cn.edu.cqut.myapp.dto.AppUserBasicDto;
import cn.edu.cqut.myapp.service.AppUserService;
import cn.edu.cqut.myapp.status.Login;
import cn.edu.cqut.myapp.util.TokenUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class AppUserController implements BaseController {

  final AppUserService appUserService;
  final TokenUtils tokenUtils;

  // TODO mybatis运行过程、插件
  // TODO pageHelper的配置与使用

  /**
   * 注册用户
   *
   * @param userBasic 注册信息
   * @return 结果
   */
  @PostMapping
  public Re signUp(@RequestBody AppUserBasicDto userBasic) {
    // 创建user
    AppUser user = appUserService.createAppUser(userBasic);
    if (user != null) {
      // 创建成功
      String token = tokenUtils.getToken(user, request());
      return Re.ok(token);
    } else {
      // 创建失败
      return Re.fail("注册失败", null);
    }
  }

  /**
   * 密码登录
   *
   * @param userBasic 登录凭证
   * @return 结果
   */
  @GetMapping
  public Re signIn(AppUserBasicDto userBasic) {
    ServiceReturnVal<Login, AppUser> val = appUserService.userLoginOnBrowser(userBasic);
    if (val.getStatus().equals(Login.LOGIN_SUCCESS)) {
      // 验证成功
      String token = tokenUtils.getToken(val.getData(), request());
      return Re.ok(token);
    } else {
      // 验证失败
      return Re.fail("登录失败", val.getStatus());
    }
  }

  /**
   * 修改用户信息
   *
   * @param userBasic 用户信息
   * @param userId    唯一标识
   * @return 结果
   */
  @AuthToken
  @PatchMapping("/{userId}")
  public Re updateUser(@RequestBody AppUserBasicDto userBasic, @PathVariable String userId) {
    userBasic.setUserId(userId);
    AppUser user = appUserService.updateAppUser(userBasic);
    if (user != null) {
      // 修改成功
      return Re.ok(user);
    } else {
      // 修改失败
      return Re.fail("修改失败", appUserService.getUserById(userId));
    }
  }

  /**
   * 获取用户信息
   *
   * @param userId 唯一标识
   * @return 结果
   */
  @AuthToken
  @GetMapping("/{userId}")
  public Re getUserById(@PathVariable String userId) {
    AppUser user = appUserService.getUserById(userId);
    return user != null ? Re.ok(user) : Re.fail("获取用户信息失败", null);
  }
}
