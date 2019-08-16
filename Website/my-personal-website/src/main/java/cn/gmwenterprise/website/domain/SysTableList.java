package cn.gmwenterprise.website.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.time.*;

/**
 * sys_table_list 
 */
@Data
@Alias("sysTableList")
public class SysTableList {
    /**
     * PRIMARY KEY<br>
     * AUTO INCREMENT<br>
     * [id] 主键
     */
    private Integer id;
    /**
     * [table_name] 表名(中文)
     */
    private String tableName;
    /**
     * [table_service_link] 表服务链接名
     */
    private String tableServiceLink;
    /**
     * [create_datetime] 创建时间
     */
    private LocalDateTime createDatetime;
    /**
     * [update_datetime] 最后更新时间
     */
    private LocalDateTime updateDatetime;
}
