package cn.gmwenterprise.website.service.impl;

import cn.gmwenterprise.website.vo.ArticleVo;
import cn.gmwenterprise.website.dao.ArticleDao;
import cn.gmwenterprise.website.domain.Article;
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
    public int insert(ArticleVo vo) {
        return articleDao.insert(domain(vo));
    }

    @Override
    public int insertSelective(ArticleVo vo) {
        return articleDao.insertSelective(domain(vo));
    }

    @Override
    public ArticleVo selectByPrimaryKey(Integer id) {
        return vo(articleDao.selectByPrimaryKey(id));
    }

    @Override
    public List<ArticleVo> selectAll(ArticleVo vo) {
        return articleDao.selectAll(domain(vo))
            .stream()
            .map(this::vo)
            .collect(Collectors.toList());
    }

    @Override
    public int updateByPrimaryKeySelective(ArticleVo vo) {
        return articleDao.updateByPrimaryKeySelective(domain(vo));
    }

    @Override
    public int updateByPrimaryKey(ArticleVo vo) {
        return articleDao.updateByPrimaryKey(domain(vo));
    }

    private ArticleVo vo(Article domain) {
        if (domain == null) {
            return null;
        }
        ArticleVo vo = new ArticleVo();
        BeanUtils.copyProperties(domain, vo);
        return vo;
    }

    private Article domain(ArticleVo vo) {
        if (vo == null) {
            return null;
        }
        Article domain = new Article();
        BeanUtils.copyProperties(vo, domain);
        return domain;
    }
}
