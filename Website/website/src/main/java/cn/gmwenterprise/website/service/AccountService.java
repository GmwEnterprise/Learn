package cn.gmwenterprise.website.service;

import cn.gmwenterprise.website.bo.AccountBo;

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
     * @param bo 记录
     * @return 受影响行数
     */
    int insert(AccountBo bo);

    /**
     * 插入满足条件的字段
     *
     * @param bo 记录
     * @return 受影响行数
     */
    int insertSelective(AccountBo bo);

    /**
     * 查询记录
     *
     * @param id 主键
     * @return 结果
     */
    AccountBo selectByPrimaryKey(Integer id);

    /**
     * 查询所有记录
     *
     * @param bo 条件
     * @return 结果
     */
    List<AccountBo> selectAll(AccountBo bo);

    /**
     * 更新满足条件的字段
     *
     * @param bo 记录
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(AccountBo bo);

    /**
     * 更新记录
     *
     * @param bo 记录
     * @return 受影响行数
     */
    int updateByPrimaryKey(AccountBo bo);

    /**
     * 通过手机号登陆或注册账户
     *
     * @param phone 手机号
     * @return 成功注册或登陆则返回信息; 失败返回null
     */
    AccountBo signByPhone(String phone);
}