package cn.gmwenterprise.website.service.impl;

import cn.gmwenterprise.website.bo.CommentBo;
import cn.gmwenterprise.website.dao.CommentDao;
import cn.gmwenterprise.website.po.Comment;
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
    public int insert(CommentBo bo) {
        return commentDao.insert(po(bo));
    }

    @Override
    public int insertSelective(CommentBo bo) {
        return commentDao.insertSelective(po(bo));
    }

    @Override
    public CommentBo selectByPrimaryKey(Integer id) {
        return bo(commentDao.selectByPrimaryKey(id));
    }

    @Override
    public List<CommentBo> selectAll(CommentBo bo) {
        return commentDao.selectAll(po(bo))
            .stream()
            .map(this::bo)
            .collect(Collectors.toList());
    }

    @Override
    public int updateByPrimaryKeySelective(CommentBo bo) {
        return commentDao.updateByPrimaryKeySelective(po(bo));
    }

    @Override
    public int updateByPrimaryKey(CommentBo bo) {
        return commentDao.updateByPrimaryKey(po(bo));
    }

    private CommentBo bo(Comment po) {
        if (po == null) {
            return null;
        }
        CommentBo bo = new CommentBo();
        BeanUtils.copyProperties(po, bo);
        return bo;
    }

    private Comment po(CommentBo bo) {
        if (bo == null) {
            return null;
        }
        Comment po = new Comment();
        BeanUtils.copyProperties(bo, po);
        return po;
    }
}
