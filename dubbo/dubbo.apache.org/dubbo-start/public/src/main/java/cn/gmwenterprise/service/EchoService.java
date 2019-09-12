package cn.gmwenterprise.service;

import java.util.List;

public interface EchoService {
    void echo(String message);

    List<String> history();
}
