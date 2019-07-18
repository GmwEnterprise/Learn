package cn.gmwenterprise.website.service;

import cn.gmwenterprise.website.bo.CommentBo;

import java.util.List;

/**
 * @author gmw
 */
public interface CommentService {

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
    int insert(CommentBo bo);

    /**
     * 插入满足条件的字段
     *
     * @param bo 记录
     * @return 受影响行数
     */
    int insertSelective(CommentBo bo);

    /**
     * 查询记录
     *
     * @param id 主键
     * @return 结果
     */
    CommentBo selectByPrimaryKey(Integer id);

    /**
     * 查询所有记录
     *
     * @param bo 条件
     * @return 结果
     */
    List<CommentBo> selectAll(CommentBo bo);

    /**
     * 更新满足条件的字段
     *
     * @param bo 记录
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(CommentBo bo);

    /**
     * 更新记录
     *
     * @param bo 记录
     * @return 受影响行数
     */
    int updateByPrimaryKey(CommentBo bo);
}