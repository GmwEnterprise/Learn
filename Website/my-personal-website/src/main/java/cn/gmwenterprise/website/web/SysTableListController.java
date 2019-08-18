package cn.gmwenterprise.website.web;

import cn.gmwenterprise.website.common.BaseController;
import cn.gmwenterprise.website.common.ResponseEntity;
import cn.gmwenterprise.website.config.mybatis.PageHelper;
import cn.gmwenterprise.website.service.SysTableListService;
import cn.gmwenterprise.website.vo.SysTableListVo;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * @author gmw
 */
@RestController
@RequestMapping("/sysTableList")
public class SysTableListController implements BaseController {
    private final SysTableListService sysTableListService;

    public SysTableListController(SysTableListService sysTableListService) {
        this.sysTableListService = sysTableListService;
    }

    /**
     * 获取更多关于指定表字段的信息，为了生成表数据的展示
     *
     * @param id 主键
     * @return 信息
     */
    @GetMapping("/more/{id}")
    public ResponseEntity queryByPrimaryKeyAndMore(@PathVariable Integer id) throws Exception {
        return ok(sysTableListService.selectMoreByPrimaryKey(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity queryByPrimaryKey(@PathVariable Integer id) {
        return ok(sysTableListService.selectByPrimaryKey(id));
    }

    @GetMapping
    public ResponseEntity queryPage(SysTableListVo vo) {
        PageHelper.startPage(vo.getCurrentPage(), vo.getPageSize());
        return ok(PageHelper.page(sysTableListService.selectPage(vo)));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody SysTableListVo vo) {
        sysTableListService.insert(vo);
        return ok();
    }

    @PatchMapping
    public ResponseEntity modify(@RequestBody SysTableListVo vo) {
        sysTableListService.updateByPrimaryKeySelective(vo);
        return ok();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        sysTableListService.deleteByPrimaryKey(id);
        return ok();
    }
}
