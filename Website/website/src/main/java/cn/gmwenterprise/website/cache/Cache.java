package cn.gmwenterprise.website.cache;

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
     * 指定key缓存是否存在
     *
     * @param key 缓存键
     * @return 结果
     */
    boolean exist(String key);
}
