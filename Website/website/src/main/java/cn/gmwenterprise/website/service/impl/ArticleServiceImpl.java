package cn.gmwenterprise.website.service.impl;

import cn.gmwenterprise.website.bo.ArticleBo;
import cn.gmwenterprise.website.dao.ArticleDao;
import cn.gmwenterprise.website.po.Article;
import cn.gmwenterprise.website.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleDao articleDao;
    
    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return articleDao.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insert(ArticleBo bo) {
        return articleDao.insert(po(bo));
    }
    
    @Override
    public int insertSelective(ArticleBo bo) {
        return articleDao.insertSelective(po(bo));
    }
    
    @Override
    public ArticleBo selectByPrimaryKey(Integer id) {
        return bo(articleDao.selectByPrimaryKey(id));
    }
    
    @Override
    public List<ArticleBo> selectAll(ArticleBo bo) {
        return articleDao.selectAll(po(bo))
            .stream()
            .map(this::bo)
            .collect(Collectors.toList());
    }

    @Override
    public int updateByPrimaryKeySelective(ArticleBo bo) {
        return articleDao.updateByPrimaryKeySelective(po(bo));
    }

    @Override
    public int updateByPrimaryKey(ArticleBo bo) {
        return articleDao.updateByPrimaryKey(po(bo));
    }

    private ArticleBo bo(Article po) {
        ArticleBo bo = new ArticleBo();
        BeanUtils.copyProperties(po, bo);
        return bo;
    }

    private Article po(ArticleBo bo) {
        Article po = new Article();
        BeanUtils.copyProperties(bo, po);
        return po;
    }
}
