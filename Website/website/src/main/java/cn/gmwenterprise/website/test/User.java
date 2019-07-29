package cn.gmwenterprise.website.test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private Integer id;
    private String userName;
    private String sex;
    private String remark;
}
