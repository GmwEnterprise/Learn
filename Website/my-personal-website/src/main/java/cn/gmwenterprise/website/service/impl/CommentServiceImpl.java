package cn.gmwenterprise.website.service.impl;

import cn.gmwenterprise.website.vo.CommentVo;
import cn.gmwenterprise.website.dao.CommentDao;
import cn.gmwenterprise.website.domain.Comment;
import cn.gmwenterprise.website.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao;

    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return commentDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CommentVo vo) {
        return commentDao.insert(domain(vo));
    }

    @Override
    public int insertSelective(CommentVo vo) {
        return commentDao.insertSelective(domain(vo));
    }

    @Override
    public CommentVo selectByPrimaryKey(Integer id) {
        return vo(commentDao.selectByPrimaryKey(id));
    }

    @Override
    public List<CommentVo> selectPage(CommentVo vo) {
        return commentDao.selectPage(domain(vo))
            .stream()
            .map(this::vo)
            .collect(Collectors.toList());
    }

    @Override
    public int updateByPrimaryKeySelective(CommentVo vo) {
        return commentDao.updateByPrimaryKeySelective(domain(vo));
    }

    @Override
    public int updateByPrimaryKey(CommentVo vo) {
        return commentDao.updateByPrimaryKey(domain(vo));
    }

    private CommentVo vo(Comment domain) {
        if (domain == null) {
            return null;
        }
        CommentVo vo = new CommentVo();
        BeanUtils.copyProperties(domain, vo);
        return vo;
    }

    private Comment domain(CommentVo vo) {
        if (vo == null) {
            return null;
        }
        Comment domain = new Comment();
        BeanUtils.copyProperties(vo, domain);
        return domain;
    }
}
