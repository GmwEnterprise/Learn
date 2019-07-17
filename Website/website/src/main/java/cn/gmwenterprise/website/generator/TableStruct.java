package cn.gmwenterprise.website.generator;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<String, Object> toMap() {
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("tableName", tableName);
        map.put("entityName", entityName);
        map.put("entityAlias", entityAlias);
        map.put("tableComment", tableComment);
        map.put("columnList", columnList.stream().map(ColumnStruct::toMap).collect(Collectors.toList()));
        return map;
    }
}
