package cn.gmwenterprise.website.web;

import cn.gmwenterprise.website.bo.CommentBo;
import cn.gmwenterprise.website.common.BaseController;
import cn.gmwenterprise.website.common.ResponseEntity;
import cn.gmwenterprise.website.service.CommentService;
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
    public ResponseEntity queryAll(CommentBo bo) {
        return ok(commentService.selectAll(bo));
    }

    @PostMapping("/")
    public ResponseEntity add(@RequestBody CommentBo bo) {
        commentService.insert(bo);
        return ok();
    }

    @PatchMapping("/")
    public ResponseEntity modify(@RequestBody CommentBo bo) {
        commentService.updateByPrimaryKeySelective(bo);
        return ok();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        commentService.deleteByPrimaryKey(id);
        return ok();
    }
}
