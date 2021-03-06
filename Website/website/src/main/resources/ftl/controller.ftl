package cn.gmwenterprise.website.web;

import cn.gmwenterprise.website.bo.${entityName}Bo;
import cn.gmwenterprise.website.common.BaseController;
import cn.gmwenterprise.website.common.ResponseEntity;
import cn.gmwenterprise.website.service.${entityName}Service;
import org.springframework.web.bind.annotation.*;

/**
 * @author gmw
 */
@RestController
@RequestMapping("/${entityAlias}")
public class ${entityName}Controller implements BaseController {
    private final ${entityName}Service ${entityAlias}Service;

    public ${entityName}Controller(${entityName}Service ${entityAlias}Service) {
        this.${entityAlias}Service = ${entityAlias}Service;
    }

    @GetMapping("/{${keyProperty}}")
    public ResponseEntity queryByPrimaryKey(@PathVariable ${keyPropertyType} ${keyProperty}) {
        return ok(${entityAlias}Service.selectByPrimaryKey(${keyProperty}));
    }

    @GetMapping("/")
    public ResponseEntity queryAll(${entityName}Bo bo) {
        return ok(${entityAlias}Service.selectAll(bo));
    }

    @PostMapping("/")
    public ResponseEntity add(@RequestBody ${entityName}Bo bo) {
        ${entityAlias}Service.insert(bo);
        return ok();
    }

    @PatchMapping("/")
    public ResponseEntity modify(@RequestBody ${entityName}Bo bo) {
        ${entityAlias}Service.updateByPrimaryKeySelective(bo);
        return ok();
    }

    @DeleteMapping("/{${keyProperty}}")
    public ResponseEntity delete(@PathVariable ${keyPropertyType} ${keyProperty}) {
        ${entityAlias}Service.deleteByPrimaryKey(${keyProperty});
        return ok();
    }
}
