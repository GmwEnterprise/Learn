package cn.edu.cqut.permission.domain;

import java.time.LocalDateTime;

public class SysRoleAcl {

  private Integer id;

  private Integer roleId;

  private Integer aclId;

  private String operator;

  private LocalDateTime operateTime;

  private String operateIp;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public Integer getAclId() {
    return aclId;
  }

  public void setAclId(Integer aclId) {
    this.aclId = aclId;
  }

  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  public LocalDateTime getOperateTime() {
    return operateTime;
  }

  public void setOperateTime(LocalDateTime operateTime) {
    this.operateTime = operateTime;
  }

  public String getOperateIp() {
    return operateIp;
  }

  public void setOperateIp(String operateIp) {
    this.operateIp = operateIp;
  }
}