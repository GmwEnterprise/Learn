package cn.edu.cqut.myapp.web;

import cn.edu.cqut.myapp.common.AuthToken;
import cn.edu.cqut.myapp.common.ResponseEntity;
import cn.edu.cqut.myapp.domain.AppUser;
import cn.edu.cqut.myapp.execution.LoginExecution;
import cn.edu.cqut.myapp.execution.enums.Login;
import cn.edu.cqut.myapp.param.AppUserUpdate;
import cn.edu.cqut.myapp.param.LoginParam;
import cn.edu.cqut.myapp.param.Register;
import cn.edu.cqut.myapp.service.AppUserService;
import cn.edu.cqut.myapp.vo.AppUserVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class AppUserController implements BaseController {

  private final AppUserService appUserService;

  /**
   * 注册账户，注册成功则自动登录并返回TOKEN信息; 注册失败则返回错误信息
   */
  @PostMapping("/reg")
  public ResponseEntity register(@Valid @RequestBody Register register, Errors errors, HttpServletRequest request) {
    if (errors.hasErrors()) {
      return fail("参数错误", errorMap(errors));
    }
    AppUser user = new AppUser();
    user.setUserPhone(register.getPhone());
    user.setUsername(register.getUsername());
    user.setPassword(register.getPassword());
    boolean result = appUserService.createAppUser(user);
    if (result) {
      // 注册成功，自动登陆
      String token = appUserService.userLoginDirectly(user, request);
      LoginExecution execution = new LoginExecution();
      execution.setToken(token);
      execution.setResult(Login.LOGIN_SUCCESS);
      return success("注册成功", execution);
    } else {
      return fail("系统异常，注册失败");
    }
  }

  /**
   * 登陆，登陆成功返回token；登陆失败返回错误信息
   */
  @PostMapping("/login")
  public ResponseEntity userLogin(@Valid @RequestBody LoginParam login, Errors errors, HttpServletRequest request) {
    if (errors.hasErrors()) {
      return fail("参数错误", errorMap(errors));
    }
    LoginExecution execution = appUserService.userLoginByPassword(login.getPhone(), login.getPassword(), request);
    if (execution.getResult() == Login.LOGIN_SUCCESS) {
      return success("登陆成功", execution);
    }
    return fail("登陆失败", execution);
  }

  /**
   * 查询用户信息
   */
  @AuthToken
  @GetMapping("/{userId}")
  public ResponseEntity userMessage(@PathVariable String userId) {
    AppUserVo user = appUserService.getAppUserById(userId);
    if (user != null) {
      return success(user);
    }
    return fail("账户不存在");
  }

  /**
   * 更新用户信息
   */
  @AuthToken
  @GetMapping("/update")
  public ResponseEntity userMessageUpdate(@Valid @RequestBody AppUserUpdate user, Errors errors) {
    if (errors.hasErrors()) {
      return fail("参数错误", errorMap(errors));
    }
    AppUser appUser = new AppUser();
    appUser.setUserId(user.getUserId());
    appUser.setUsername(user.getUsername());
    appUser.setUserPhone(user.getUserPhone());
    appUser.setUserEmail(user.getUserEmail());
    AppUser result = appUserService.userUpdate(appUser);
    if (result != null) {
      return success(result);
    }
    return fail("修改失败");
  }
}
