package cn.gmwenterprise.website.po;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("${classAlias}")
public class ${className} {
    <#list columns as column>
    private ${column.type} ${column.name};
    </#list>
}
