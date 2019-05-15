package cn.edu.cqut.myapp.util;

import com.google.common.collect.Maps;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public final class RequestUtils {

  public static String formParamStringify(HttpServletRequest request) {
    if (request.getParameterMap().size() == 0) {
      return "[]";
    }
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    Enumeration<String> names = request.getParameterNames();
    while (names.hasMoreElements()) {
      String key = names.nextElement();
      sb.append(key)
          .append("=(")
          .append(request.getParameter(key))
          .append("), ");
    }
    return sb.delete(sb.length() - 2, sb.length()).append("]").toString();
  }

  public static Map<String, Object> requestMessage(HttpServletRequest request) {
    HashMap<String, Object> map = Maps.newHashMap();
    map.put("url", request.getRequestURL().toString());
    map.put("port", request.getRemotePort());
    map.put("userAgent", request.getHeader("User-Agent"));
    return map;
  }
}
