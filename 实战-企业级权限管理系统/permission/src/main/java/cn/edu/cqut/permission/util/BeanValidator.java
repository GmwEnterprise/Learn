package cn.edu.cqut.permission.util;

import com.google.common.collect.Maps;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

public class BeanValidator {

  private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

  public static <E> Map<String, String> validate(E e, Class<?>... groups) {
    Validator validator = validatorFactory.getValidator();
    Set<ConstraintViolation<E>> validateResult = validator.validate(e, groups);
    if (validateResult.isEmpty()) {
      return Collections.emptyMap();
    } else {
      LinkedHashMap<String, String> errors = Maps.newLinkedHashMap();
      for (ConstraintViolation<E> error : validateResult) {
        errors.put(error.getPropertyPath().toString(), error.getMessage());
      }
      return errors;
    }
  }
}
