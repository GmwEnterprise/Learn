package cn.gmwenterprise.dubbo.provider;

import cn.gmwenterprise.dubbo.common.EchoService;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;

import java.time.LocalDateTime;

@Service
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String message) {
        System.out.println(String.format("[%s] Hello %s, request from consumer: %s",
            LocalDateTime.now().toString(), message,
            RpcContext.getContext().getRemoteAddressString()));
        return message;
    }
}
