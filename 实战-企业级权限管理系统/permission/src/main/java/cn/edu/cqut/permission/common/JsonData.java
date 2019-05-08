package cn.edu.cqut.permission.common;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class JsonData {

  private Boolean ret;
  private String msg;
  private Object data;

  private JsonData(boolean ret) {
    this.ret = ret;
  }

  public static JsonData success(Object data, String msg) {
    JsonData jsonData = new JsonData(true);
    jsonData.setData(data);
    jsonData.setMsg(msg);
    return jsonData;
  }

  public static JsonData success(Object data) {
    JsonData jsonData = new JsonData(true);
    jsonData.setData(data);
    return jsonData;
  }

  public static JsonData success() {
    return new JsonData(true);
  }

  public static JsonData fail(String msg) {
    JsonData jsonData = new JsonData(false);
    jsonData.setMsg(msg);
    return jsonData;
  }

  public Map<String, Object> toMap() {
    HashMap<String, Object> map = new HashMap<>();
    map.put("ret", ret);
    map.put("msg", msg);
    map.put("data", data);
    return map;
  }
}
