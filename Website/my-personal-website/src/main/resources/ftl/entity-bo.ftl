package cn.gmwenterprise.website.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.*;

/**
 * ${entityName} 业务对象
 */
@Data
public class ${entityName}Vo {
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
    <#if field.fieldType == 'LocalDateTime'>
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    </#if>
    <#if field.fieldType == 'LocalDate'>
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    </#if>
    <#if field.fieldType == 'LocalTime'>
    @DateTimeFormat(pattern = "HH:mm:ss")
    </#if>
    private ${field.fieldType} ${field.fieldName};
</#list>
}
