package cn.edu.cqut.myapp.web;

import cn.edu.cqut.myapp.domain.AppUser;
import cn.edu.cqut.myapp.dto.LoginDto;
import cn.edu.cqut.myapp.dto.RegisterDto;
import cn.edu.cqut.myapp.enums.LoginExecution;
import cn.edu.cqut.myapp.service.AppUserService;
import cn.edu.cqut.myapp.util.TokenUtils;
import cn.edu.cqut.myapp.vo.AjaxResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class AppUserController implements BaseController {

  private final AppUserService appUserService;
  private final TokenUtils tokenUtils;

  @PostMapping("/reg")
  public AjaxResponse register(@RequestBody @Valid RegisterDto data, Errors errors) {
    if (errors.hasErrors()) {
      return paramErrorOutput(errors.getAllErrors());
    }
    AppUser user = new AppUser();
    user.setUsername(data.getUsername());
    user.setPassword(data.getPassword());
    user.setUserPhone(data.getPhone());
    log.info("{}", user);
    return appUserService.createUser(user) ? success() : fail();
  }

  @PostMapping("/login")
  public AjaxResponse login(@RequestBody @Valid LoginDto data, Errors errors) {
    if (errors.hasErrors()) {
      return paramErrorOutput(errors.getAllErrors());
    }
    AppUser user = new AppUser();
    user.setUserPhone(data.getPhone());
    user.setPassword(data.getPassword());
    log.info("{}", user);
    LoginExecution execution = appUserService.userLoginByPassword(user);
    if (execution == LoginExecution.SUCCESS) {
      AppUser appUser = appUserService.getUserByPhone(user.getUserPhone());
      String token = tokenUtils.getToken(appUser);
      return success("登陆成功", token);
    }
    return fail(execution.getMessage());
  }

  @GetMapping("/getUserByToken")
  public AppUser getUserByToken(String token) {
    // TODO redis序列化过程中Java8日期的转换
    AppUser appUser = tokenUtils.checkToken(token);
    log.info("user message: {}", appUser);
    return appUser;
  }
}
