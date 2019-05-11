package cn.edu.cqut.permission.util;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;

@Slf4j
public class JsonMapper {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  static {
    OBJECT_MAPPER.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES)
        .configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false)
        .setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY)
        .setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
  }

  public static <T> String obj2String(T src) {
    if (src == null) {
      return null;
    }
    try {
      return src instanceof String ? (String) src : OBJECT_MAPPER.writeValueAsString(src);
    } catch (IOException e) {
      log.warn("parse object to string exception", e);
      return null;
    }
  }

  public static <T> T string2Obj(String src, TypeReference<T> typeReference) {
    if (src == null || typeReference == null) {
      return null;
    }
    try {
      return typeReference.getType().equals(String.class) ? (T) src : OBJECT_MAPPER.readValue(src, typeReference);
    } catch (IOException e) {
      log.warn("parse string to object exception, string: {}, TypeReference<T>: {}, error: {}", src, typeReference.getType(), e);
      return null;
    }
  }
}
