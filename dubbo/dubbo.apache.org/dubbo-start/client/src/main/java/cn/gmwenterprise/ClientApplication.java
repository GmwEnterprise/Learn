package cn.gmwenterprise;

import cn.gmwenterprise.service.EchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Reference(url = "dubbo://192.168.140.1:12345")
    private EchoService echoService;

    @GetMapping("/echo/{msg}")
    public String echo(@PathVariable String msg) {
        echoService.echo(msg);
        return "success echo: " + msg;
    }

    @GetMapping("/see")
    public List<String> echos() {
        return echoService.history();
    }
}
