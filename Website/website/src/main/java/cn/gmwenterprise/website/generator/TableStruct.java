package cn.gmwenterprise.website.generator;

import lombok.Data;

import java.util.List;

/**
 * 表结构
 */
@Data
class TableStruct {
    /**
     * 表名
     */
    private String tableName;

    /**
     * 表对应的实体类名
     */
    private String entityName;

    /**
     * mybatis实体类名别名, 为首字母小写的类名
     */
    private String entityAlias;

    /**
     * 表注释
     */
    private String tableComment;

    /**
     * 表的所有字段
     */
    private List<ColumnStruct> columnList;
}
