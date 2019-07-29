package cn.gmwenterprise.website.test;

public interface SqlInjector {

    /**
     * 注入sql参数
     * @param origin
     * @param instance
     * @return
     */
    String inject(String origin, Object instance) throws Exception;
}
