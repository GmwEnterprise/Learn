package cn.gmwenterprise.website.web;

import cn.gmwenterprise.website.common.BaseController;
import cn.gmwenterprise.website.common.ResponseEntity;
import cn.gmwenterprise.website.config.mybatis.PageHelper;
import cn.gmwenterprise.website.service.AccountService;
import cn.gmwenterprise.website.vo.AccountVo;
import org.springframework.web.bind.annotation.*;

/**
 * @author gmw
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BaseController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity queryByPrimaryKey(@PathVariable Integer id) {
        return ok(accountService.selectByPrimaryKey(id));
    }

    @GetMapping
    public ResponseEntity queryPage(AccountVo vo) {
        PageHelper.startPage(vo.getCurrentPage(), vo.getPageSize());
        return ok(PageHelper.page(accountService.selectPage(vo)));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody AccountVo vo) {
        accountService.insert(vo);
        return ok();
    }

    @PatchMapping
    public ResponseEntity modify(@RequestBody AccountVo vo) {
        accountService.updateByPrimaryKeySelective(vo);
        return ok();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        accountService.deleteByPrimaryKey(id);
        return ok();
    }
}
