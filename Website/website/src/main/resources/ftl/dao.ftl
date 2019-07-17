package cn.gmwenterprise.website.dao;

import cn.gmwenterprise.website.po.${entityName};
import org.springframework.stereotype.Repository;

/**
* @author gmw
*/
@Repository
public interface ${entityName}Dao {
    
    /**
     * 删除记录
     *
     * @param ${primaryKey} 主键
     * @return 受影响行数
     */
    int deleteByPrimaryKey(Integer ${primaryKey});
    
    /**
     * 插入记录
     *
     * @param record 记录
     * @return 受影响行数
     */
    int insert(${entityName} record);
    
    /**
     * 插入满足条件的字段
     *
     * @param record 记录
     * @return 受影响行数
     */
    int insertSelective(${entityName} record);

    /**
     * 查询记录
     *
     * @param ${primaryKey} 主键
     * @return 结果
     */
    ${entityName} selectByPrimaryKey(Integer ${primaryKey});
    
    /**
     * 更新满足条件的字段
     *
     * @param record 记录
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(${entityName} record);
    
    /**
     * 更新记录
     *
     * @param record 记录
     * @return 受影响行数
     */
    int updateByPrimaryKey(${entityName} record);
}