package cn.gmwenterprise.website.web;

import cn.gmwenterprise.website.common.BaseController;
import cn.gmwenterprise.website.common.ResponseEntity;
import cn.gmwenterprise.website.service.DatabaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sys")
public class SystemController implements BaseController {

    @Resource(name = "databaseServiceImpl")
    DatabaseService databaseService;

    @GetMapping("/tableList")
    public ResponseEntity getTableList() {
        return ok(databaseService.getTableList());
    }
}
