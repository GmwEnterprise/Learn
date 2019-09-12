package cn.gmwenterprise.dubbo.samples.provider;

import cn.gmwenterprise.dubbo.samples.api.GreetingService;

public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHi(String name) {
        return "Hi, " + name;
    }
}
