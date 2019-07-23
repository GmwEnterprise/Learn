package cn.gmwenterprise.website.cache;

import java.util.List;

public interface Cache {

    /**
     * 设置缓存并指定过期时间
     *
     * @param key   缓存键
     * @param value 缓存值
     * @param delay 过期时间，单位：秒
     */
    void set(String key, Object value, long delay);

    /**
     * 设置缓存
     *
     * @param key   缓存键
     * @param value 缓存值
     */
    void set(String key, Object value);

    /**
     * 获取缓存
     *
     * @param key 缓存键
     * @return 结果
     */
    Object get(String key);

    /**
     * 获取指定类型缓存
     *
     * @param clazz 指定类型
     * @param key 缓存键
     * @return 结果
     */
    <E> E get(Class<E> clazz, String key);

    /**
     * 获取指定类型缓存列表
     *
     * @param clazz 指定类型
     * @param key 缓存键
     * @return 结果
     */
    <E> List<E> getList(Class<E> clazz, String key);

    /**
     * 指定key缓存是否存在
     *
     * @param key 缓存键
     * @return 结果
     */
    boolean exist(String key);
}
