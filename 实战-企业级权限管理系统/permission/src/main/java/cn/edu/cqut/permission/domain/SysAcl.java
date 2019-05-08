package cn.edu.cqut.permission.domain;

import java.time.LocalDateTime;

public class SysAcl {

  private Integer id;

  private String code;

  private String name;

  private Integer aclModuleId;

  private String url;

  private Integer type;

  private Integer status;

  private Integer seq;

  private String remark;

  private String operator;

  private LocalDateTime operateTime;

  private String operateIp;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAclModuleId() {
    return aclModuleId;
  }

  public void setAclModuleId(Integer aclModuleId) {
    this.aclModuleId = aclModuleId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getSeq() {
    return seq;
  }

  public void setSeq(Integer seq) {
    this.seq = seq;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
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