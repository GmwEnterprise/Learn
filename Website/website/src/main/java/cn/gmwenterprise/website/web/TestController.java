package cn.gmwenterprise.website.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Slf4j
@Controller
public class TestController {

    @Resource
    public TestInterface testInterface;
}
