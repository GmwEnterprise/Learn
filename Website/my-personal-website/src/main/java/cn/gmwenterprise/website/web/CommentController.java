package cn.gmwenterprise.website.web;

import cn.gmwenterprise.website.common.BaseController;
import cn.gmwenterprise.website.common.ResponseEntity;
import cn.gmwenterprise.website.config.mybatis.PageHelper;
import cn.gmwenterprise.website.service.CommentService;
import cn.gmwenterprise.website.vo.CommentVo;
import org.springframework.web.bind.annotation.*;

/**
 * @author gmw
 */
@RestController
@RequestMapping("/comment")
public class CommentController implements BaseController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity queryByPrimaryKey(@PathVariable Integer id) {
        return ok(commentService.selectByPrimaryKey(id));
    }

    @GetMapping("/")
    public ResponseEntity queryAll(CommentVo vo) {
        PageHelper.startPage(vo.getCurrentPage(), vo.getPageSize());
        return ok(PageHelper.page(commentService.selectAll(vo)));
    }

    @PostMapping("/")
    public ResponseEntity add(@RequestBody CommentVo vo) {
        commentService.insert(vo);
        return ok();
    }

    @PatchMapping("/")
    public ResponseEntity modify(@RequestBody CommentVo vo) {
        commentService.updateByPrimaryKeySelective(vo);
        return ok();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        commentService.deleteByPrimaryKey(id);
        return ok();
    }
}
