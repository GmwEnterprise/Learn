package cn.gmwenterprise.website.web;

import cn.gmwenterprise.website.bo.ArticleBo;
import cn.gmwenterprise.website.common.BaseController;
import cn.gmwenterprise.website.common.ResponseEntity;
import cn.gmwenterprise.website.service.ArticleService;
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

    @GetMapping("/")
    public ResponseEntity queryAll(ArticleBo bo) {
        return ok(articleService.selectAll(bo));
    }

    @PostMapping("/")
    public ResponseEntity add(@RequestBody ArticleBo bo) {
        articleService.insert(bo);
        return ok();
    }

    @PatchMapping("/")
    public ResponseEntity modify(@RequestBody ArticleBo bo) {
        articleService.updateByPrimaryKeySelective(bo);
        return ok();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        articleService.deleteByPrimaryKey(id);
        return ok();
    }
}
