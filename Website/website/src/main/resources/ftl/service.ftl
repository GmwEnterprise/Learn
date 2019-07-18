package cn.gmwenterprise.website.service;

import cn.gmwenterprise.website.bo.${entityName}Bo;

import java.util.List;

/**
 * @author gmw
 */
public interface ${entityName}Service {

    /**
     * 删除记录
     *
     * @param ${keyProperty} 主键
     * @return 受影响行数
     */
    int deleteByPrimaryKey(${keyPropertyType} ${keyProperty});

    /**
     * 插入记录
     *
     * @param bo 记录
     * @return 受影响行数
     */
    int insert(${entityName}Bo bo);

    /**
     * 插入满足条件的字段
     *
     * @param bo 记录
     * @return 受影响行数
     */
    int insertSelective(${entityName}Bo bo);

    /**
     * 查询记录
     *
     * @param ${keyProperty} 主键
     * @return 结果
     */
    ${entityName}Bo selectByPrimaryKey(${keyPropertyType} ${keyProperty});

    /**
     * 查询所有记录
     *
     * @param bo 条件
     * @return 结果
     */
    List<${entityName}Bo> selectAll(${entityName}Bo bo);

    /**
     * 更新满足条件的字段
     *
     * @param bo 记录
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(${entityName}Bo bo);

    /**
     * 更新记录
     *
     * @param bo 记录
     * @return 受影响行数
     */
    int updateByPrimaryKey(${entityName}Bo bo);
}