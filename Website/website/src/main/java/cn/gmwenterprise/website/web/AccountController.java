package cn.gmwenterprise.website.web;

import cn.gmwenterprise.website.bo.AccountBo;
import cn.gmwenterprise.website.common.BaseController;
import cn.gmwenterprise.website.common.ResponseEntity;
import cn.gmwenterprise.website.service.AccountService;
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

    @GetMapping("/")
    public ResponseEntity queryAll(AccountBo bo) {
        return ok(accountService.selectAll(bo));
    }

    @PostMapping("/")
    public ResponseEntity add(@RequestBody AccountBo bo) {
        accountService.insert(bo);
        return ok();
    }

    @PatchMapping("/")
    public ResponseEntity modify(@RequestBody AccountBo bo) {
        accountService.updateByPrimaryKeySelective(bo);
        return ok();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        accountService.deleteByPrimaryKey(id);
        return ok();
    }
}
