package cn.edu.cqut.permission.domain;

public class SysLogWithBLOBs extends SysLog {

  private String oldValue;

  private String newValue;

  public String getOldValue() {
    return oldValue;
  }

  public void setOldValue(String oldValue) {
    this.oldValue = oldValue;
  }

  public String getNewValue() {
    return newValue;
  }

  public void setNewValue(String newValue) {
    this.newValue = newValue;
  }
}