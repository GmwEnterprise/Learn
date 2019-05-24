package cn.edu.cqut.myapp.web;

import cn.edu.cqut.myapp.common.AuthToken;
import cn.edu.cqut.myapp.dto.AppUserBasicDto;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

  @GetMapping
  public String test() {
    return "default request for this controller";
  }

  @AuthToken
  @GetMapping("/a")
  public String test1() {
    return "test !!!";
  }

  @GetMapping("/b")
  public String test2() {
    return "test !!!";
  }

  @GetMapping("/headerMsg")
  public String headerMessage(HttpServletRequest request) {
    Enumeration<String> headerNames = request.getHeaderNames();
    Map<String, String> headers = Maps.newHashMap();
    while (headerNames.hasMoreElements()) {
      String key = headerNames.nextElement();
      headers.put(key, request.getHeader(key));
    }
    System.out.println(headers);
    System.out.println(request.getRemoteHost());
    System.out.println(request.getRemoteAddr());
    System.out.println(request.getRemotePort());
    return request.toString();
  }

  @GetMapping("testJson")
  public String func(@RequestBody AppUserBasicDto dto) {
    log.info("param => {}", dto);
    return "";
  }
}
