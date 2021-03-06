package cn.gmwenterprise.website.bo;

import lombok.Data;

import java.time.*;

/**
 * ${entityName} 业务对象
 */
@Data
public class ${entityName}Bo {
<#list columnList as field>
    /**
    <#if field.isPrimaryKey>
     * PRIMARY KEY${'<br>'}
    </#if>
    <#if field.isAutoIncrement>
     * AUTO INCREMENT${'<br>'}
    </#if>
     * [${field.columnName}] ${field.columnComment}
     */
    private ${field.fieldType} ${field.fieldName};
</#list>
}
