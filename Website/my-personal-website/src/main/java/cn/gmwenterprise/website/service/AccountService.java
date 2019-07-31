package cn.gmwenterprise.website.service;

import cn.gmwenterprise.website.vo.AccountVo;

import java.util.List;

/**
 * @author gmw
 */
public interface AccountService {

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
    int insert(AccountVo vo);

    /**
     * 插入满足条件的字段
     *
     * @param vo 记录
     * @return 受影响行数
     */
    int insertSelective(AccountVo vo);

    /**
     * 查询记录
     *
     * @param id 主键
     * @return 结果
     */
    AccountVo selectByPrimaryKey(Integer id);

    /**
     * 查询所有记录
     *
     * @param vo 条件
     * @return 结果
     */
    List<AccountVo> selectAll(AccountVo vo);

    /**
     * 更新满足条件的字段
     *
     * @param vo 记录
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(AccountVo vo);

    /**
     * 更新记录
     *
     * @param vo 记录
     * @return 受影响行数
     */
    int updateByPrimaryKey(AccountVo vo);

    AccountVo signByEmail(String email);
}