package cn.gmwenterprise.website.service;

import cn.gmwenterprise.website.vo.SysTableListVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @author gmw
 */
public interface SysTableListService {

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
    int insert(SysTableListVo vo);

    /**
     * 插入满足条件的字段
     *
     * @param vo 记录
     * @return 受影响行数
     */
    int insertSelective(SysTableListVo vo);

    /**
     * 查询记录
     *
     * @param id 主键
     * @return 结果
     */
    SysTableListVo selectByPrimaryKey(Integer id);

    /**
     * 查询所有记录
     *
     * @param vo 条件
     * @return 结果
     */
    List<SysTableListVo> selectPage(SysTableListVo vo);

    /**
     * 更新满足条件的字段
     *
     * @param vo 记录
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(SysTableListVo vo);

    /**
     * 更新记录
     *
     * @param vo 记录
     * @return 受影响行数
     */
    int updateByPrimaryKey(SysTableListVo vo);

    SysTableListVo selectMoreByPrimaryKey(Integer id) throws Exception;
}