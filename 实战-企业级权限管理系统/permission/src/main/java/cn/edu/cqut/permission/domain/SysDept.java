package cn.edu.cqut.permission.domain;

import java.time.LocalDateTime;

public class SysDept {

  private Integer id;

  private String name;

  private Integer parentId;

  private String level;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
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