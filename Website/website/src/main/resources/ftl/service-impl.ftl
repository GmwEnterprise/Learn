package cn.gmwenterprise.website.service.impl;

import cn.gmwenterprise.website.bo.${entityName}Bo;
import cn.gmwenterprise.website.dao.${entityName}Dao;
import cn.gmwenterprise.website.po.${entityName};
import cn.gmwenterprise.website.service.${entityName}Service;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ${entityName}ServiceImpl implements ${entityName}Service {
    private final ${entityName}Dao ${entityAlias}Dao;

    public ${entityName}ServiceImpl(${entityName}Dao ${entityAlias}Dao) {
        this.${entityAlias}Dao = ${entityAlias}Dao;
    }

    @Override
    public int deleteByPrimaryKey(${keyPropertyType} ${keyProperty}) {
        return ${entityAlias}Dao.deleteByPrimaryKey(${keyProperty});
    }

    @Override
    public int insert(${entityName}Bo bo) {
        return ${entityAlias}Dao.insert(po(bo));
    }

    @Override
    public int insertSelective(${entityName}Bo bo) {
        return ${entityAlias}Dao.insertSelective(po(bo));
    }

    @Override
    public ${entityName}Bo selectByPrimaryKey(${keyPropertyType} ${keyProperty}) {
        return bo(${entityAlias}Dao.selectByPrimaryKey(${keyProperty}));
    }

    @Override
    public List<${entityName}Bo> selectAll(${entityName}Bo bo) {
        return ${entityAlias}Dao.selectAll(po(bo))
            .stream()
            .map(this::bo)
            .collect(Collectors.toList());
    }

    @Override
    public int updateByPrimaryKeySelective(${entityName}Bo bo) {
        return ${entityAlias}Dao.updateByPrimaryKeySelective(po(bo));
    }

    @Override
    public int updateByPrimaryKey(${entityName}Bo bo) {
        return ${entityAlias}Dao.updateByPrimaryKey(po(bo));
    }

    private ${entityName}Bo bo(${entityName} po) {
        if (po == null) {
            return null;
        }
        ${entityName}Bo bo = new ${entityName}Bo();
        BeanUtils.copyProperties(po, bo);
        return bo;
    }

    private ${entityName} po(${entityName}Bo bo) {
        if (bo == null) {
            return null;
        }
        ${entityName} po = new ${entityName}();
        BeanUtils.copyProperties(bo, po);
        return po;
    }
}
