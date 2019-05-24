package cn.edu.cqut.myapp.common;

import lombok.Data;

/**
 * 作为service层返回的数据结构
 *
 * @param <S> 状态枚举
 * @param <D> 携带数据
 */
@Data
public class ServiceReturnVal<S extends Enum<S>, D> {

  private S status;

  private D data;
}
