package cn.edu.cqut.myapp.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

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
}
