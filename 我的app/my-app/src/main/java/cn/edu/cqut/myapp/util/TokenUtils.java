package cn.edu.cqut.myapp.util;

import cn.edu.cqut.myapp.domain.AppUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

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
    key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    this.redisUtils = redisUtils;
  }

  public String getToken(AppUser user, HttpServletRequest request) {
    // 获取请求来源信息，封装
    Map<String, Object> requestMessage = RequestUtils.requestMessage(request);
    // 生成token
    long currentTimeMillis = System.currentTimeMillis();
    Date now = new Date(currentTimeMillis);
    Date expire = new Date(currentTimeMillis + expireMills);
    String token = Jwts.builder()
        // subject为userId
        .setSubject(user.getUserId())
        .setIssuer(issuer)
        .setIssuedAt(now)
        .setExpiration(expire)
        // claims中添加客户端信息
        .setClaims(requestMessage)
        .signWith(key)
        .compact();
    // 存储token到redis
    redisUtils.set(token, user, expireMills);
    return token;
  }

  /**
   * 验证token
   *
   * @param token token
   * @return 通过返回AppUser 不通过返回null
   */
  public AppUser checkToken(String token, HttpServletRequest request) {
    try {
      // token是否存在
      Object user = redisUtils.get(token);
      if (user instanceof AppUser) {
        // 解析token
        Claims body = Jwts.parser()
            .setSigningKey(key)
            .parseClaimsJws(token)
            .getBody();
        // 从token中取出客户端信息并验证当前请求是否来自同一个客户端
        Map<String, Object> requestMessage = RequestUtils.requestMessage(request);
        boolean flag = true;
        for (Map.Entry<String, Object> entry : requestMessage.entrySet()) {
          flag = flag && body.get(entry.getKey()).equals(entry.getValue());
        }
        if (flag) {
          // 是同一个客户端
          return (AppUser) user;
        }
      }
    } catch (JwtException e) {
      log.error("token验证失败", e);
    }
    return null;
  }
}
