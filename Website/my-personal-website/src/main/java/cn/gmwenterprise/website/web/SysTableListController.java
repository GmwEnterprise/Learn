package cn.gmwenterprise.website.web;

import cn.gmwenterprise.website.common.BaseController;
import cn.gmwenterprise.website.common.ResponseEntity;
import cn.gmwenterprise.website.config.mybatis.PageHelper;
import cn.gmwenterprise.website.service.SysTableListService;
import cn.gmwenterprise.website.vo.SysTableListVo;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity queryByPrimaryKey(@PathVariable Integer id) {
        return ok(sysTableListService.selectByPrimaryKey(id));
    }

    @GetMapping
    public ResponseEntity queryAll(SysTableListVo vo) {
        PageHelper.startPage(vo.getCurrentPage(), vo.getPageSize());
        return ok(PageHelper.page(sysTableListService.selectAll(vo)));
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
