package cn.edu.cqut.myapp.service;

import cn.edu.cqut.myapp.domain.AppUser;
import cn.edu.cqut.myapp.execution.LoginExecution;
import cn.edu.cqut.myapp.vo.AppUserVo;

import javax.servlet.http.HttpServletRequest;

public interface AppUserService {

  /**
   * 通过绑定的手机号获取用户信心
   *
   * @param phone 手机号
   * @return 用户信息
   */
  AppUser getAppUserByPhone(String phone);

  /**
   * 创建用户
   *
   * @param user 用户数据
   * @return 是否创建成功
   */
  boolean createAppUser(AppUser user);

  /**
   * 通过密码验证登陆
   *
   * @param password 密码
   * @return 验证结果
   */
  LoginExecution userLoginByPassword(String phone, String password, HttpServletRequest request);

  /**
   * 直接设置用户为登陆状态
   *
   * @param user 用户信息
   * @return token
   */
  String userLoginDirectly(AppUser user, HttpServletRequest request);

  /**
   * 获取用户信息并传递到前端
   *
   * @param userId 用户主键
   * @return 用户信息VO
   */
  AppUserVo getAppUserById(String userId);

  AppUser userUpdate(AppUser appUser);
}
