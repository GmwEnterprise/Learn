package cn.edu.cqut.myapp.util;

import cn.edu.cqut.myapp.domain.AppUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Objects;

@Slf4j
@Component
@PropertySource(value = "classpath:globalParam.properties")
public class TokenUtils {

  private SecretKey key;
  private final RedisUtils redisUtils;

  @Value("${jwt.issuer}")
  private String issuer;

  @Value("${jwt.expire-mills}")
  private Long expireMills;

  public TokenUtils(RedisUtils redisUtils) {
    this.redisUtils = redisUtils;
    key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
  }

  private String getTokenKey(String userId, HttpServletRequest request) {
    Objects.requireNonNull(userId);
    String requestMsg = String.format("%s-%s:%d/%s", userId, request.getRequestURL(),
        request.getRemotePort(), request.getHeader("User-Agent"));
    return DigestUtils.md5DigestAsHex(requestMsg.getBytes());
  }

  /**
   * 生成token字符串并将其存储到redis缓存，key为请求信息，value为token
   *
   * @param user    用户信息
   * @param request 请求对象
   * @return token字符串
   */
  public String getToken(AppUser user, HttpServletRequest request) {
    // 通过参数映射为key
    String key = getTokenKey(user.getUserId(), request);
    // 生成token
    long currentTimeMillis = System.currentTimeMillis();
    Date now = new Date(currentTimeMillis);
    Date expire = new Date(currentTimeMillis + expireMills);
    String token = Jwts.builder()
        .setSubject(user.getUserId())
        .setIssuer(issuer)
        .setIssuedAt(now)
        .setExpiration(expire)
        .signWith(this.key)
        .compact();
    // 存储token到redis
    redisUtils.set(key, token, expireMills);
    return token;
  }

  /**
   * 验证token
   *
   * @param token token
   * @return 通过返回AppUser, 不通过返回null
   */
  public boolean checkToken(String token, HttpServletRequest request) {
    try {
      String userId = Jwts.parser()
          .setSigningKey(key)
          .parseClaimsJws(token)
          .getBody()
          .getSubject();
      String key = getTokenKey(userId, request);
      Object value = redisUtils.get(key);
      return value != null && value.equals(token);
    } catch (Exception e) {
      log.error("token验证失败：" + e.getMessage());
    }
    return false;
  }

  /**
   * 主动清除token，主要用于注销登陆
   *
   * @param token token
   */
  public void clearToken(String token) {
    redisUtils.del(token);
  }
}
