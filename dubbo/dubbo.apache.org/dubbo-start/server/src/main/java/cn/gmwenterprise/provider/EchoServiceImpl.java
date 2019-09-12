package cn.gmwenterprise.provider;

import cn.gmwenterprise.service.EchoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EchoServiceImpl implements EchoService {
    private List<String> echoList = new ArrayList<>();

    @Override
    public void echo(String message) {
        log.info("echo: {}", message);
        echoList.add(message);
    }

    @Override
    public List<String> history() {
        return echoList;
    }
}
