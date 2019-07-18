package cn.gmwenterprise.website.dao;

import cn.gmwenterprise.website.po.Article;
import org.springframework.stereotype.Repository;

/**
* @author gmw
*/
@Repository
public interface ArticleDao {
    
    /**
     * 删除记录
     *
     * @param id 主键
     * @return 受影响行数
     */
    int deleteByPrimaryKey(Integer id);
    
    /**
     * 插入记录
     *
     * @param record 记录
     * @return 受影响行数
     */
    int insert(Article record);
    
    /**
     * 插入满足条件的字段
     *
     * @param record 记录
     * @return 受影响行数
     */
    int insertSelective(Article record);

    /**
     * 查询记录
     *
     * @param id 主键
     * @return 结果
     */
    Article selectByPrimaryKey(Integer id);
    
    /**
     * 更新满足条件的字段
     *
     * @param record 记录
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(Article record);
    
    /**
     * 更新记录
     *
     * @param record 记录
     * @return 受影响行数
     */
    int updateByPrimaryKey(Article record);
}