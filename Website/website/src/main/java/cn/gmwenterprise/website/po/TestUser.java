package cn.gmwenterprise.website.po;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("testUser")
public class TestUser {
    private String username;
}
