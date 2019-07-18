package cn.gmwenterprise.website.web;

import cn.gmwenterprise.website.bo.ArticleBo;
import cn.gmwenterprise.website.common.BaseController;
import cn.gmwenterprise.website.common.ResponseEntity;
import cn.gmwenterprise.website.service.ArticleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController implements BaseController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{key}")
    public ResponseEntity queryByPrimaryKey(@PathVariable Integer key) {
        return ok(articleService.selectByPrimaryKey(key));
    }

    @GetMapping("/")
    public ResponseEntity queryByPrimaryKey(@RequestBody ArticleBo bo) {
        return ok(articleService.selectAll(bo));
    }

    // TODO
}
