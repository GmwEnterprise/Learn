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
import java.util.Date;

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

  public String getToken(AppUser user) {
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
  public AppUser checkToken(String token) {
    try {
      // token是否存在于redis
      Object user = redisUtils.get(token);
      if (user instanceof AppUser) {
        // 解析token
        Claims body = Jwts.parser()
            .setSigningKey(key)
            .parseClaimsJws(token)
            .getBody();
        return (AppUser) user;
      }
    } catch (JwtException e) {
      log.error("token验证失败", e);
    }
    return null;
  }

  public void clearToken(String token) {
    redisUtils.del(token);
  }
}
