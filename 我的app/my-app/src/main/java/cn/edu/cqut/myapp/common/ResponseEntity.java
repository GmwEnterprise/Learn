package cn.edu.cqut.myapp.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class ResponseEntity {

  private Boolean success;

  private String message;

  private Object body;

  private Object errorMsg;
}
