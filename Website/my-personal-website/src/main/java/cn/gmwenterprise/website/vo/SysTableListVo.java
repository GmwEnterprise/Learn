package cn.gmwenterprise.website.vo;

import lombok.Data;

import java.time.*;

/**
 * SysTableList 业务对象
 */
@Data
public class SysTableListVo {
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

    /**
     * 当前页（入参）
     */
    private Integer currentPage;
    /**
     * 每页条数（入参）
     */
    private Integer pageSize;
}
