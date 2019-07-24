package cn.gmwenterprise.website.service;

import cn.gmwenterprise.website.bo.ArticleBo;

import java.util.List;

/**
 * @author gmw
 */
public interface ArticleService {

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
     * @param bo 记录
     * @return 受影响行数
     */
    int insert(ArticleBo bo);

    /**
     * 插入满足条件的字段
     *
     * @param bo 记录
     * @return 受影响行数
     */
    int insertSelective(ArticleBo bo);

    /**
     * 查询记录
     *
     * @param id 主键
     * @return 结果
     */
    ArticleBo selectByPrimaryKey(Integer id);

    /**
     * 查询所有记录
     *
     * @param bo 条件
     * @return 结果
     */
    List<ArticleBo> selectAll(ArticleBo bo);

    /**
     * 更新满足条件的字段
     *
     * @param bo 记录
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(ArticleBo bo);

    /**
     * 更新记录
     *
     * @param bo 记录
     * @return 受影响行数
     */
    int updateByPrimaryKey(ArticleBo bo);
}