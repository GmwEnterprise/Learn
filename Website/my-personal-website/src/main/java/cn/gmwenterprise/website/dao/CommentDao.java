package cn.gmwenterprise.website.dao;

import cn.gmwenterprise.website.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gmw
 */
@Repository
public interface CommentDao {

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
    int insert(Comment record);

    /**
     * 插入满足条件的字段
     *
     * @param record 记录
     * @return 受影响行数
     */
    int insertSelective(Comment record);

    /**
     * 查询记录
     *
     * @param id 主键
     * @return 结果
     */
    Comment selectByPrimaryKey(Integer id);

    /**
     * 查询所有记录
     *
     * @param record 条件
     * @return 结果
     */
    List<Comment> selectPage(Comment record);

    /**
     * 更新满足条件的字段
     *
     * @param record 记录
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(Comment record);

    /**
     * 更新记录
     *
     * @param record 记录
     * @return 受影响行数
     */
    int updateByPrimaryKey(Comment record);
}