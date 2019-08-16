package cn.gmwenterprise.website.dao;

import cn.gmwenterprise.website.domain.SysTableList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gmw
 */
@Repository
public interface SysTableListDao {

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
    int insert(SysTableList record);

    /**
     * 插入满足条件的字段
     *
     * @param record 记录
     * @return 受影响行数
     */
    int insertSelective(SysTableList record);

    /**
     * 查询记录
     *
     * @param id 主键
     * @return 结果
     */
    SysTableList selectByPrimaryKey(Integer id);

    /**
     * 查询所有记录
     *
     * @param record 条件
     * @return 结果
     */
    List<SysTableList> selectAll(SysTableList record);

    /**
     * 更新满足条件的字段
     *
     * @param record 记录
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(SysTableList record);

    /**
     * 更新记录
     *
     * @param record 记录
     * @return 受影响行数
     */
    int updateByPrimaryKey(SysTableList record);
}