package cn.gmwenterprise.website.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys")
public class BackstageRouter {

    // 代码生成器 #############################

    @GetMapping("/codec")
    public String toCodeHelperPage() {
        return "codec";
    }
}
