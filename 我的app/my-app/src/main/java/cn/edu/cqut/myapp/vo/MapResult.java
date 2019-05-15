package cn.edu.cqut.myapp.vo;

import com.google.common.collect.Maps;
import lombok.Getter;

import java.util.Map;

@Getter
public class MapResult<E> {

  private E execution;
  private Map<String, Object> data;

  public MapResult(E execution) {
    this.execution = execution;
    data = Maps.newHashMap();
  }

  public MapResult set(String key, Object val) {
    data.put(key, val);
    return this;
  }
}