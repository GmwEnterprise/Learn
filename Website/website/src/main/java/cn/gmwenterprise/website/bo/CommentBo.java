package cn.gmwenterprise.website.bo;

import lombok.Data;

import java.time.*;

/**
 * Comment 业务对象
 */
@Data
public class CommentBo {
    /**
     * PRIMARY KEY<br>
     * AUTO INCREMENT<br>
     * [id] 主键
     */
    private Integer id;
    /**
     * [comment_writer] 评论人，account.account_id
     */
    private String commentWriter;
    /**
     * [comment_content] 评论内容
     */
    private String commentContent;
    /**
     * [comment_belong] 评论的文章主键
     */
    private Integer commentBelong;
    /**
     * [create_datetime] 评论时间
     */
    private LocalDateTime createDatetime;
    /**
     * [status] 该条评论状态，1-公开，2-删除
     */
    private Integer status;
}
