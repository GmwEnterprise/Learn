package cn.edu.cqut.permission.util;

import cn.edu.cqut.permission.common.ParamException;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

public class BeanValidator {

  private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

  public static <E> Map<String, String> validate(E e, Class<?>... groups) {
    // 获取一个validator
    Validator validator = validatorFactory.getValidator();
    // 自动获取校验结果
    Set<ConstraintViolation<E>> validateResult = validator.validate(e, groups);
    if (validateResult.isEmpty()) {
      // 没有错误
      return Collections.emptyMap();
    } else {
      // 有错误
      LinkedHashMap<String, String> errors = Maps.newLinkedHashMap();
      for (ConstraintViolation<E> violation : validateResult) {
        // key -> 有问题字段，value -> 错误信息
        errors.put(violation.getPropertyPath().toString(), violation.getMessage());
      }
      return errors;
    }
  }

  public static Map<String, String> validateList(Collection<?> collection) {
    Preconditions.checkNotNull(collection);
    Map<String, String> errors = null;
    for (Object o : collection) {
      errors = validate(o);
      if (!errors.isEmpty()) {
        break;
      }
    }
    return errors == null? Collections.emptyMap() : errors;
  }

  public static Map<String, String> validateObject(Object first, Object... objects) {
    if (objects != null && objects.length > 0) {
      return validateList(Lists.asList(first, objects));
    } else {
      return validate(first);
    }
  }

  private static void check(Object param) throws ParamException {
    Map<String, String> map = validateObject(param);
    if (MapUtils.isNotEmpty(map)) {
      throw new ParamException(map.toString());
    }
  }
}
