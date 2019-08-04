package cn.gmwenterprise.website.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDatetime;
    /**
     * [update_datetime] 字段上一次更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDatetime;
}
