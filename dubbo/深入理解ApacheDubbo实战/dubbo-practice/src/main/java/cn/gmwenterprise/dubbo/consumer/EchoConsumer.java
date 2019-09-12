package cn.gmwenterprise.dubbo.consumer;

import cn.gmwenterprise.dubbo.common.EchoService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class EchoConsumer implements EchoService {
    @Reference
    private EchoService echoService;

    @Override
    public String echo(String message) {
        return echoService.echo(message);
    }
}
