package cn.gmwenterprise.website.vo;

import lombok.Data;

import java.time.*;

/**
 * Account 业务对象
 */
@Data
public class AccountVo {
    /**
     * PRIMARY KEY<br>
     * AUTO INCREMENT<br>
     * [id] 主键
     */
    private Integer id;
    /**
     * [account_id] 账户ID，唯一标识，可做个人链接
     */
    private String accountId;
    /**
     * [account_type] 账户类型，1-读者，2-作者
     */
    private Integer accountType;
    /**
     * [nickname] 昵称
     */
    private String nickname;
    /**
     * [sex] 性别
     */
    private Integer sex;
    /**
     * [age] 年龄
     */
    private Integer age;
    /**
     * [introduction] 个人介绍
     */
    private String introduction;
    /**
     * [phone] 手机号
     */
    private String phone;
    /**
     * [email] 邮箱，注册必填
     */
    private String email;
    /**
     * [create_datetime] 字段创建时间
     */
    private LocalDateTime createDatetime;
    /**
     * [update_datetime] 字段上一次更新时间
     */
    private LocalDateTime updateDatetime;

    /**
     * 当前页（入参）
     */
    private Integer currentPage;
    /**
     * 每页条数（入参）
     */
    private Integer pageSize;
}
