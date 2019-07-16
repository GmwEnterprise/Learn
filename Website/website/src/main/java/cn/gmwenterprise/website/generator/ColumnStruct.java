package cn.gmwenterprise.website.generator;

import lombok.Data;

@Data
class ColumnStruct {
    /**
     * 字段名
     */
    private String columnName;

    /**
     * 字段对应的数据库类型
     */
    private String columnType;

    /**
     * 字段对应的数据库类型，对应java.sql.Types
     */
    private int columnTypeNo;

    /**
     * 字段注释
     */
    private String columnComment;

    /**
     * 列对应的成员名
     */
    private String fieldName;

    /**
     * 成员类型
     */
    private String fieldType;
}
