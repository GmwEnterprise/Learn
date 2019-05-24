package cn.edu.cqut.myapp.service;

import cn.edu.cqut.myapp.common.ServiceReturnVal;
import cn.edu.cqut.myapp.domain.AppUser;
import cn.edu.cqut.myapp.dto.AppUserBasicDto;
import cn.edu.cqut.myapp.status.Login;

public interface AppUserService {

  /**
   * 创建用户
   *
   * @param userBasic 用户信息
   * @return 创建成功返回用户信息；创建失败返回空
   */
  AppUser createAppUser(AppUserBasicDto userBasic);

  /**
   * 更新用户
   *
   * @param userBasic 用户信息
   * @return 更新成功返回更新后的用户信息；更新失败返回空
   */
  AppUser updateAppUser(AppUserBasicDto userBasic);

  /**
   * 删除用户
   *
   * @param userId 主键
   * @return 若不存在指定ID用户则返回空；反之则返回该用户信息
   */
  AppUser deleteAppUser(String userId);

  /**
   * 获取用户
   *
   * @param phone 手机号
   * @return 用户信息
   */
  AppUser getUserByPhone(String phone);

  /**
   * 获取用户
   *
   * @param userId 主键
   * @return 用户信息
   */
  AppUser getUserById(String userId);

  /**
   * 用户浏览器登陆
   *
   * @param userBasic 登陆信息
   * @return 登陆结果。成功则额外返回用户信息
   */
  ServiceReturnVal<Login, AppUser> userLoginOnBrowser(AppUserBasicDto userBasic);
}
