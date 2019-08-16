package cn.gmwenterprise.website.service;

import cn.gmwenterprise.website.vo.CommentVo;

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
     * @param vo 记录
     * @return 受影响行数
     */
    int insert(CommentVo vo);

    /**
     * 插入满足条件的字段
     *
     * @param vo 记录
     * @return 受影响行数
     */
    int insertSelective(CommentVo vo);

    /**
     * 查询记录
     *
     * @param id 主键
     * @return 结果
     */
    CommentVo selectByPrimaryKey(Integer id);

    /**
     * 查询所有记录
     *
     * @param vo 条件
     * @return 结果
     */
    List<CommentVo> selectPage(CommentVo vo);

    /**
     * 更新满足条件的字段
     *
     * @param vo 记录
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(CommentVo vo);

    /**
     * 更新记录
     *
     * @param vo 记录
     * @return 受影响行数
     */
    int updateByPrimaryKey(CommentVo vo);
}