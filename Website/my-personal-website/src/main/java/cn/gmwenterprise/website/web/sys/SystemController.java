package cn.gmwenterprise.website.web.sys;

import cn.gmwenterprise.website.common.BaseController;
import cn.gmwenterprise.website.common.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/system")
public class SystemController implements BaseController {

    @GetMapping("/moduleColumns/{moduleName}")
    public ResponseEntity moduleColumns(@PathVariable String moduleName) throws ClassNotFoundException {
        if (Character.isLowerCase(moduleName.charAt(0))) {
            String className = Character.toUpperCase(moduleName.charAt(0)) + moduleName.substring(1);
            return ok(Arrays.stream(Class.forName("cn.gmwenterprise.website.vo." + className + "Vo").getDeclaredFields())
                .filter(field -> !"currentPage".equals(field.getName()) && !"pageSize".equals(field.getName()))
                .map(Field::getName)
                .collect(Collectors.toList()));
        }
        return fail("moduleName不符合驼峰命名规则");
    }
}
