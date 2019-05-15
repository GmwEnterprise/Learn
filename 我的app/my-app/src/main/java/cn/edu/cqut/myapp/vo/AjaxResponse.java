package cn.edu.cqut.myapp.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AjaxResponse {

  private Boolean success;
  private String message;
  private Object body;
}
