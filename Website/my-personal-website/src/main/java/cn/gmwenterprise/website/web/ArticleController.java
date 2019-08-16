package cn.gmwenterprise.website.web;

import cn.gmwenterprise.website.common.BaseController;
import cn.gmwenterprise.website.common.ResponseEntity;
import cn.gmwenterprise.website.config.mybatis.PageHelper;
import cn.gmwenterprise.website.service.ArticleService;
import cn.gmwenterprise.website.vo.ArticleVo;
import org.springframework.web.bind.annotation.*;

/**
 * @author gmw
 */
@RestController
@RequestMapping("/article")
public class ArticleController implements BaseController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity queryByPrimaryKey(@PathVariable Integer id) {
        return ok(articleService.selectByPrimaryKey(id));
    }

    @GetMapping
    public ResponseEntity queryPage(ArticleVo vo) {
        PageHelper.startPage(vo.getCurrentPage(), vo.getPageSize());
        return ok(PageHelper.page(articleService.selectPage(vo)));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody ArticleVo vo) {
        articleService.insert(vo);
        return ok();
    }

    @PatchMapping
    public ResponseEntity modify(@RequestBody ArticleVo vo) {
        articleService.updateByPrimaryKeySelective(vo);
        return ok();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        articleService.deleteByPrimaryKey(id);
        return ok();
    }
}
